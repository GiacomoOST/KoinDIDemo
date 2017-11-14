package com.ostmodern.koininjectiondemo.di

import com.ostmodern.koininjectiondemo.R
import com.ostmodern.koininjectiondemo.di.PersistenceModule.Companion.PERSISTENT
import com.ostmodern.koininjectiondemo.di.PersistenceModule.Companion.TEMPORARY
import com.ostmodern.koininjectiondemo.repository.MainRepository
import com.ostmodern.koininjectiondemo.viewmodels.MainViewModel
import org.koin.android.module.AndroidModule

fun koinInjectionDemoModules() = listOf(MainActivityModule(), PersistenceModule(), PropertiesModule())

class MainActivityModule : AndroidModule() {

    override fun context() = applicationContext {
        context(MainActivityModule.NAME) {
            provide { MainViewModel(get(TEMPORARY), get(PERSISTENT)) }
        }
    }

    companion object {
        const val NAME = "MainActivity"
    }

}

class PersistenceModule : AndroidModule() {

    override fun context() = applicationContext {
        provide(TEMPORARY) { MainRepository(TEMPORARY) }
        provide(PERSISTENT) { MainRepository(PERSISTENT) }
    }

    companion object {
        const val TEMPORARY = "TEMPORARY"
        const val PERSISTENT = "PERSISTENT"
    }

}

class PropertiesModule : AndroidModule() {

    override fun context() = applicationContext {

        koinContext.setProperty(APP_NAME, androidApplication.getString(R.string.app_name))

    }

    companion object {
        const val APP_NAME = "app_name"
    }

}