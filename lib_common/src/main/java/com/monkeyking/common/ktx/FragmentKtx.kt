package com.monkeyking.common.ktx

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner

//region 扩展函数
/**
 * Activity中使用DataBinding时setContentView的简化
 * [layout] 布局文件
 * @return 返回一个Binding的实例
 */
fun <T: ViewDataBinding> FragmentActivity.bindView (layout:Int): T{
    return DataBindingUtil.setContentView(this,layout);
}

/**
 * Activity中使用DataBinding时setContentView的简化
 * [view] View
 * @return 返回一个Binding的实例 泛型
 */
fun <T: ViewDataBinding> FragmentActivity.bindView (view: View): T?{
    return DataBindingUtil.bind<T>(view);
}

/**
 * 界面Activity沉浸式状态栏,使状态栏里可以显示图片
 * 注意!!! 需要在setContentView之前调用才会生效
 */
fun FragmentActivity.immediateStatusBar(){
    window.apply {
        addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)
        addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}

/**
 * 软键盘隐藏
 * [view] 事件控件view
 */
fun FragmentActivity.dismissKeyBoard(view: View){
    val imm: InputMethodManager? = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager?
    imm?.hideSoftInputFromWindow(view.windowToken,0);
}

//endregion

//region 扩展属性

/**
 * 扩展lifecycleOwner属性,便于和fragment之间使用lifecycleOwner 一致性
 */
val FragmentActivity.viewLifeCycleOwner: LifecycleOwner
    get() = this

/**
 * Activity的扩展字段,便于和fragment中使用liveData时,参数一致性
 */
val FragmentActivity.context: Context
    get() = this
//endregion