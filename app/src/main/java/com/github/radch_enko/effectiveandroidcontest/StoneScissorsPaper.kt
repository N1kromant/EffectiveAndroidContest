package com.github.radch_enko.effectiveandroidcontest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.github.radch_enko.effectiveandroidcontest.core.steps.Action
import com.github.radch_enko.effectiveandroidcontest.core.steps.GetNextAction
import com.github.radch_enko.effectiveandroidcontest.core.steps.StoneScissorsPaper
import kotlin.random.Random

@Composable
fun StoneScissorsPaperScreen(onSuccess: () -> Unit) {
    var i = 0

    StoneScissorsPaper(
        getNextAction = object : GetNextAction {
            override fun invoke(): Action {

                val result = when(i) {
                    in 0..5 -> getRandomAction()
                    6 -> Action.STONE
                    7 -> Action.SCISSORS
                    8 -> Action.STONE
                    9 -> Action.PAPER
                    else -> { i = -1; Action.SCISSORS }
                }
                i++

                return result
            }
        },
        onSuccess = onSuccess,
    )
}

fun getRandomAction(): Action {
    val actions = Action.entries.toTypedArray()
    return actions[Random.nextInt(actions.size)]
}