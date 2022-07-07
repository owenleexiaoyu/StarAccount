package com.owenandroid.staraccount.app

import android.app.Application
import com.owenandroid.staraccount.BuildConfig
import com.tencent.bugly.crashreport.CrashReport
import org.litepal.LitePal

class StarApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 初始化 Bugly SDK
        CrashReport.initCrashReport(applicationContext, AppConfig.BUGLY_APPID, BuildConfig.DEBUG)
        // 初始化 Litepal 数据库
        LitePal.initialize(this)
    }
}