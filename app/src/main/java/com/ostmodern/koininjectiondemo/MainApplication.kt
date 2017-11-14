package com.ostmodern.koininjectiondemo

import android.app.Application
import com.ostmodern.koininjectiondemo.modules.MainModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.startAndroidContext

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startAndroidContext(this, appModules())

        getKoin().setProperty("ApplicationContext", this)
    }

    fun appModules() = listOf( MainModule() )

}