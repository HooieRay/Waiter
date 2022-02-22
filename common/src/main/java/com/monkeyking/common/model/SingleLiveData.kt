package com.monkeyking.common.model

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 单事件响应的liveData,只有一个接收者可以收到信息,可以避免不必要的业务场景中的事件消费通知
 * 只有调用call的时候,observer才能收到通知
 */
class SingleLiveData<T>:MutableLiveData<T>() {

    private val mPending = AtomicBoolean(false);

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (hasObservers()){
            Log.w(TAG,"多个观察者存在的时候,只会有一个被通知到数据更新")
        }
        super.observe(owner, Observer {t->
            if (mPending.compareAndSet(true,false)){
                observer.onChanged(t)
            }
        })
    }

    override fun setValue(value: T) {
        mPending.set(true)
        super.setValue(value)
    }

    @MainThread
    fun call(){
        postValue(null)
        //value = null

    }

    companion object{
        private const val TAG = "SingleLiveData"
    }
}