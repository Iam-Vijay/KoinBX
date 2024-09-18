package com.vijay.koinbx.module

import com.vijay.koinbx.repository.FirebaseRepository
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideFirebaseRepository(): FirebaseRepository {
        return FirebaseRepository()
    }
}