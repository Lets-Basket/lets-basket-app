package com.example.letsbasket.manageToken

import android.app.Application
import androidx.multidex.MultiDexApplication

class App : MultiDexApplication() {
    companion object{
        lateinit var prefs:Prefs
    }
    override fun onCreate() {
        prefs=Prefs(applicationContext)
        super.onCreate()
    }
}