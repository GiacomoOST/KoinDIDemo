package com.ostmodern.koininjectiondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ostmodern.koininjectiondemo.viewmodels.MainViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    // Inject my ViewModel
    val mainViewModel by inject<MainViewModel>("Temporary")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.showAToast(this)
    }
}
