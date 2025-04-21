package com.github.radch_enko.effectiveandroidcontest.providers

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import androidx.compose.ui.res.stringResource
import com.github.radch_enko.effectiveandroidcontest.R
import com.github.radch_enko.effectiveandroidcontest.core.CreateSecretKey.generate

class SecretKeyProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        context?.getString(R.string.secret_word)?.let { this.generate(it) }
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val cursor = MatrixCursor(arrayOf("key", "value"))
        cursor.addRow(arrayOf("secret", "kotlin_in_action"))
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null
    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int = 0
    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0
    override fun getType(uri: Uri): String? = null
}