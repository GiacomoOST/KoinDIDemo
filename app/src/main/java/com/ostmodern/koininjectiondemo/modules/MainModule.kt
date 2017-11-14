package com.ostmodern.koininjectiondemo.modules

import com.ostmodern.koininjectiondemo.repository.MainRepository
import com.ostmodern.koininjectiondemo.viewmodels.MainViewModel
import org.koin.android.module.AndroidModule

class MainModule : AndroidModule() {

    override fun context() = applicationContext {
        context("MainActivity") {
            provide { MainViewModel(get()) }
        }

        provide { MainRepository() }

    }

}