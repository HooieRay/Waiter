package com.monkeyking.common.base

import android.app.Application
import com.blankj.utilcode.util.LogUtils
import com.monkeyking.common.ktx.application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * 抽象公用的BaseApplication
 */
abstract class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR) //log level Error 方能保证这句话不出错,要不就不写这个
            //context
            androidContext(this@BaseApplication)
        }

        initConfig()
        initData()
        LogUtils.d("BaseApplication onCreate")
    }

    /**
     * 可用于必要的配置初始化
     */
    protected open fun initConfig(){}

    /**
     * 可用于子类必要的数据初始化
     */
    protected open fun initData(){}
}