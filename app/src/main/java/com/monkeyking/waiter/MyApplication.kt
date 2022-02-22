package com.monkeyking.waiter

import com.monkeyking.common.base.BaseApplication
import com.monkeyking.common.ktx.application
import com.monkeyking.service.assistant.AssistantApp

class MyApplication : BaseApplication() {
//    override fun onCreate() {
//        super.onCreate()
//        ProcessLifecycleOwner.get()
//                .lifecycle
//                .addObserver(ApplicationObserver())
//    }

    override fun initConfig() {
        super.initConfig()

        //dokit初始化配置
        AssistantApp.initConfig(application)
    }
}