package com.github.radch_enko.effectiveandroidcontest

import android.app.Application
import android.content.ContentProvider
import android.content.Context
import android.net.Uri
import android.util.Log
import com.github.radch_enko.effectiveandroidcontest.core.SetupApplicationWithSecret
import com.github.radch_enko.effectiveandroidcontest.core.Storage
import com.github.radch_enko.effectiveandroidcontest.core.StorageFactory
import com.github.radch_enko.effectiveandroidcontest.providers.SecretKeyProvider
import androidx.core.net.toUri

class ContestApplication : Application() {
    private var storage: Storage? = StorageFactory.getInstance()

    override fun onCreate() {
        super.onCreate()
        SecretKeyProvider()

        with(SetupApplicationWithSecret) {
            initialize()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        storage = null
    }
}