package com.monkeyking.service.assistant

import android.app.Application
import com.didichuxing.doraemonkit.DoraemonKit
import com.didichuxing.doraemonkit.kit.AbstractKit

/**
 * 配置dokit工具类
 */
object AssistantApp {

    fun initConfig(application: Application){
        DoraemonKit.install(application, mutableListOf<AbstractKit>(
            ServerHostKit()
        ))
    }
}