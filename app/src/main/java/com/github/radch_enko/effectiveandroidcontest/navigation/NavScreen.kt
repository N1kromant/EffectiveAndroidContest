package com.github.radch_enko.effectiveandroidcontest.navigation;

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavScreen {

    @Serializable
    data object Initial : NavScreen

    @Serializable
    data object Login : NavScreen

    @Serializable
    data object OptimizeListScreen : NavScreen

    @Serializable
    data object ExactLocation: NavScreen

    @Serializable
    data object StoneScissorsPaper: NavScreen

    @Serializable
    data object Finish: NavScreen
}
