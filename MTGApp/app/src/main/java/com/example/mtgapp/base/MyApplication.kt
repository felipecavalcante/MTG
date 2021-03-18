package com.example.mtgapp.base

import android.app.Application
import com.example.mtgapp.base.di.appModule
import com.example.mtgapp.features.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(
                listOf(
                    appModule,
                    homeModule
                )
            )
        }
    }
}
