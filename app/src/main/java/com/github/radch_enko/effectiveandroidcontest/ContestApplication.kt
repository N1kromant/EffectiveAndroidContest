package com.github.radch_enko.effectiveandroidcontest

import android.app.Application
import android.content.ContentProvider
import android.content.Context
import android.location.LocationManager
import android.location.Location
import android.location.provider.ProviderProperties

import android.net.Uri
import android.os.Build
import android.util.Log
import com.github.radch_enko.effectiveandroidcontest.core.SetupApplicationWithSecret
import com.github.radch_enko.effectiveandroidcontest.core.Storage
import com.github.radch_enko.effectiveandroidcontest.core.StorageFactory
import com.github.radch_enko.effectiveandroidcontest.providers.SecretKeyProvider
import androidx.core.net.toUri
import com.github.radch_enko.effectiveandroidcontest.providers.MockLocationManager


class ContestApplication : Application() {
    private var storage: Storage? = StorageFactory.getInstance()
    private lateinit var mockLocationManager: MockLocationManager

    override fun onCreate() {
        super.onCreate()
        SecretKeyProvider()

        //В системе обязательно разрешить подмену локации!!
        mockLocationManager = MockLocationManager(this)
        mockLocationManager.setMockLocation()

        with(SetupApplicationWithSecret) {
            initialize()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        storage = null
    }
}