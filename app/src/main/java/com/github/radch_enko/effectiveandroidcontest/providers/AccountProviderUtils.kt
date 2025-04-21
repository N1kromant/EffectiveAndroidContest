package com.github.radch_enko.effectiveandroidcontest.providers

import android.content.Context
import android.util.Log
import androidx.core.net.toUri

object AccountProvider {

    fun getAccounts(context: Context): List<Account> {
        val accounts = mutableListOf<Account>()
        val uri = "content://com.github.radch_enko.dataproviderapp/accounts".toUri()

        try {
            context.contentResolver.query(
                uri,
                null,
                null,
                null,
                null
            )?.use { cursor ->
                if (cursor.moveToFirst()) {
                    do {
                        val login = cursor.getString(cursor.getColumnIndexOrThrow("login"))
                        val password = cursor.getString(cursor.getColumnIndexOrThrow("password"))

                        accounts.add(Account(login, password))
                    } while (cursor.moveToNext())
                }
            }
        } catch (e: Exception) {
            Log.e("AccountProvider", "Error querying content provider", e)
        }

        return accounts
    }
}

data class Account(val login: String, val password: String)