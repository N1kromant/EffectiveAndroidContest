package com.github.radch_enko.effectiveandroidcontest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.radch_enko.effectiveandroidcontest.core.steps.LaggyListWrapper
import com.github.radch_enko.effectiveandroidcontest.core.steps.ListItem

@Composable
fun LaggyListScreen(onSuccess: () -> Unit) {
    LaggyListWrapper(onSuccess = onSuccess) { _list ->
        val list = remember { _list }

        Column(modifier = Modifier) {

            list.forEach {
                ListItem(modifier = Modifier, rainbow = it)
            }
        }
    }
}
