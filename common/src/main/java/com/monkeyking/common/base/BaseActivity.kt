package com.monkeyking.common.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.monkeyking.common.ktx.bindView

/**
 * activity抽象基类
 */
abstract class BaseActivity<ActBinding:ViewDataBinding>:AppCompatActivity{

    constructor():super()

    constructor(@LayoutRes layout:Int):super(layout)

    protected lateinit var mBinding: ActBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = bindView<ActBinding>(getLayoutRes())
        initConfig()
        initView()
        initData()
    }

    @LayoutRes
    abstract fun getLayoutRes():Int

    open fun initConfig(){}

    open fun initView(){}

    open fun initData(){}

    override fun onDestroy() {
        super.onDestroy()
        if (this::mBinding.isInitialized){
            mBinding.unbind()
        }
    }
    /**
     * 扩展LiveData的observer扩展函数
     */
    protected fun <T:Any>LiveData<T>.observeKt(block:(T?)->Unit){
        this.observe(this@BaseActivity, Observer{
            data ->block(data)
        })
    }
}