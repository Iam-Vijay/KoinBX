package com.vijay.koinbx.component

import androidx.fragment.app.FragmentActivity
import com.vijay.koinbx.MainActivity
import com.vijay.koinbx.module.AppModule
import com.vijay.koinbx.module.ViewModelModule
import com.vijay.koinbx.ui.home.slidefragments.NewCurrencyFragment
import dagger.Component

@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(activity: FragmentActivity)

}