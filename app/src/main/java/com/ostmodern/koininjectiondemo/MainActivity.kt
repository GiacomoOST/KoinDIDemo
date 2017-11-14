package com.ostmodern.koininjectiondemo

import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ostmodern.koininjectiondemo.viewmodels.MainViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.property

class MainActivity : AppCompatActivity() {

    // Inject my ViewModel
    val mainViewModel by inject<MainViewModel>("Temporary")

    val applicationContext by property<Application>("ApplicationContext")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.showAToast(this)
    }
}
