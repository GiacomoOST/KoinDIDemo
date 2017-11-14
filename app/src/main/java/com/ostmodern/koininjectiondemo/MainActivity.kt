package com.ostmodern.koininjectiondemo

import android.app.Application
import android.os.Bundle
import com.ostmodern.koininjectiondemo.di.MainActivityModule
import com.ostmodern.koininjectiondemo.di.PropertiesModule
import com.ostmodern.koininjectiondemo.viewmodels.MainViewModel
import org.koin.android.contextaware.ContextAwareActivity
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.property

class MainActivity : ContextAwareActivity() {

    override val contextName = MainActivityModule.NAME

    // Inject my ViewModel
    val mainViewModel by inject<MainViewModel>()

    val applicationContext by property<Application>("Application")

    val appName by property<String>(PropertiesModule.APP_NAME)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.showAToast(this, appName)
    }
}
