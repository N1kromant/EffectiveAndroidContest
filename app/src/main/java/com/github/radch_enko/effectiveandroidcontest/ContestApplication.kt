package com.github.radch_enko.effectiveandroidcontest

import android.app.Application
import com.github.radch_enko.effectiveandroidcontest.core.SetupApplicationWithSecret
import com.github.radch_enko.effectiveandroidcontest.core.Storage
import com.github.radch_enko.effectiveandroidcontest.core.StorageFactory

class ContestApplication : Application() {

    private var storage: Storage? = StorageFactory.getInstance()

    override fun onCreate() {
        super.onCreate()
        with(SetupApplicationWithSecret) {
            initialize()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        storage = null
    }
}