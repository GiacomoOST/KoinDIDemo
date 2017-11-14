package com.ostmodern.koininjectiondemo.viewmodels

import android.content.Context
import android.widget.Toast
import com.ostmodern.koininjectiondemo.repository.MainRepository

class MainViewModel(private val tempRepo: MainRepository, private val persistentRepo: MainRepository) {

    fun showAToast(context: Context) {
        Toast.makeText(context, "We injected the MainViewModel. Woohoo!", Toast.LENGTH_LONG).show()
    }

}