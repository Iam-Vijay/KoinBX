package com.vijay.koinbx

import android.app.Application
import com.vijay.koinbx.component.AppComponent
import com.vijay.koinbx.component.DaggerAppComponent
import com.vijay.koinbx.module.AppModule

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }
}