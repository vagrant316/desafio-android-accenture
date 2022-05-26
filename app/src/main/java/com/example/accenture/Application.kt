package com.example.accenture

import android.app.Application
import com.example.accenture.ui.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // declare used Android context
            androidContext(this@Application)
            // declare modules
            modules(appModules)
        }
    }


}