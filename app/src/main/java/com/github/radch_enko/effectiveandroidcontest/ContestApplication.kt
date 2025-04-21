package com.github.radch_enko.effectiveandroidcontest

import android.app.Application
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.CancellationSignal
import android.util.Log
import com.github.radch_enko.effectiveandroidcontest.core.CreateSecretKey
import com.github.radch_enko.effectiveandroidcontest.core.CreateSecretKey.generate
import com.github.radch_enko.effectiveandroidcontest.core.SetupApplicationWithSecret
import com.github.radch_enko.effectiveandroidcontest.core.Storage
import com.github.radch_enko.effectiveandroidcontest.core.StorageFactory
import java.security.KeyStore
import javax.crypto.SecretKey

class ContestApplication : Application() {
    private var storage: Storage? = StorageFactory.getInstance()

    override fun onCreate() {
        super.onCreate()
        SecretKeyProvider()
//        storage?.secretKey = "a290bGluX2luX2FjdGlvbjA5MDEyMDAz"
        with(SetupApplicationWithSecret) {
            initialize()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        storage = null
    }
}