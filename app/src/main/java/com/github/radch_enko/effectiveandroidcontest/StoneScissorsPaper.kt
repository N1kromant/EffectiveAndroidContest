package com.github.radch_enko.effectiveandroidcontest

import androidx.compose.runtime.Composable
import com.github.radch_enko.effectiveandroidcontest.core.steps.Action
import com.github.radch_enko.effectiveandroidcontest.core.steps.GetNextAction
import com.github.radch_enko.effectiveandroidcontest.core.steps.StoneScissorsPaper

@Composable
fun StoneScissorsPaperScreen(onSuccess: () -> Unit) {
    StoneScissorsPaper(
        getNextAction = object : GetNextAction {
            override fun invoke(): Action {
                // TODO реализуй свою стратегию
                return Action.SCISSORS
            }
        },
        onSuccess = onSuccess,
    )
}