package com.art.task4

import android.app.Application
import com.art.task4.di.appModule
import org.koin.android.ext.android.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(androidContext = this, modules = listOf(appModule))
    }
}