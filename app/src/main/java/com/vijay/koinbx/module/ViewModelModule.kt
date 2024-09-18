package com.vijay.koinbx.module

import androidx.lifecycle.ViewModel
import com.vijay.koinbx.ui.home.HomeViewModel
import com.vijay.koinbx.ui.home.slidefragments.NewCurrencyViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {


    @Binds
    abstract fun bindUserViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun bindNewCurrencyViewModel(viewModel: NewCurrencyViewModel): ViewModel
}