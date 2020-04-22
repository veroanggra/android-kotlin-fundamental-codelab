package com.veronica.idn.guesstheword.common

import android.app.Application
import timber.log.Timber

class GuessWordApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}