package com.github.radch_enko.effectiveandroidcontest

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import com.github.radch_enko.effectiveandroidcontest.core.gray
import com.github.radch_enko.effectiveandroidcontest.navigation.Root
import com.github.radch_enko.effectiveandroidcontest.ui.theme.EffectiveAndroidContestTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            EffectiveAndroidContestTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = gray,
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Root()
                    }
                }
            }
        }
    }
}