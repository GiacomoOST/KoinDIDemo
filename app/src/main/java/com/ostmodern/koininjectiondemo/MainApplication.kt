package com.ostmodern.koininjectiondemo

import android.app.Application
import com.ostmodern.koininjectiondemo.di.koinInjectionDemoModules
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.startAndroidContext

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startAndroidContext(this, koinInjectionDemoModules())

        getKoin().setProperty("Application", this)
    }

}