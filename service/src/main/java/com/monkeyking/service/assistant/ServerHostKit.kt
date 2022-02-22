package com.monkeyking.service.assistant

import android.content.Context
import com.didichuxing.doraemonkit.kit.AbstractKit
import com.monkeyking.service.R

/**
 * 用来切换不同的接口host,调试工具
 */
class ServerHostKit :AbstractKit(){

    override val icon: Int
        get() = R.drawable.ic_server_host

    override val name: Int
        get() = R.string.str_server_host_dokit

    override fun onAppInit(context: Context?) {
        //
    }

    override fun onClick(context: Context?) {
       //
    }


}