package com.mahmoudhamdyae.tmdb

import android.app.Application
import com.mahmoudhamdyae.tmdb.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TmdbApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TmdbApplication)
            modules(appModule)
        }
    }
}