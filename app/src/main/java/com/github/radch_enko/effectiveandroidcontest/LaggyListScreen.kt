package com.github.radch_enko.effectiveandroidcontest

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.github.radch_enko.effectiveandroidcontest.core.steps.LaggyListWrapper
import com.github.radch_enko.effectiveandroidcontest.core.steps.ListItem

@Composable
fun LaggyListScreen(onSuccess: () -> Unit) {
    LaggyListWrapper(onSuccess = onSuccess) { list ->
        Column(modifier = Modifier) {
            list.forEach {
                ListItem(modifier = Modifier, rainbow = it)
            }
        }
    }
}
