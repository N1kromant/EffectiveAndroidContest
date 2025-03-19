package com.github.radch_enko.effectiveandroidcontest.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.radch_enko.effectiveandroidcontest.LaggyListScreen
import com.github.radch_enko.effectiveandroidcontest.StoneScissorsPaperScreen
import com.github.radch_enko.effectiveandroidcontest.core.StorageFactory
import com.github.radch_enko.effectiveandroidcontest.core.steps.AuthorizationFormStep
import com.github.radch_enko.effectiveandroidcontest.core.steps.ExactLocation
import com.github.radch_enko.effectiveandroidcontest.core.steps.Finish
import com.github.radch_enko.effectiveandroidcontest.core.utils.LoginData

@Composable
fun Root() {

    val navController = rememberNavController()

    val storage by remember { mutableStateOf(StorageFactory.getInstance()) }

    NavHost(
        navController = navController,
        startDestination = if (!storage.isSuccessSecretInit) NavScreen.Initial else NavScreen.Login
    ) {
        composable<NavScreen.Initial> {
            Text(
                text = "Задача: \nИнициализировать ContestApplication с ключом безопасности",
            )
        }
        composable<NavScreen.Login> {
            val localContext = LocalContext.current
            val loginData = LoginData("", "") // TODO напиши свою логику извлечения этих данных
            AuthorizationFormStep(
                initialLogin = loginData?.login.orEmpty(),
                initialPassword = loginData?.password.orEmpty(),
                onSuccessLogin = {
                    navController.popBackStack()
                    navController.navigate(route = NavScreen.OptimizeListScreen)
                }
            )
        }
        composable<NavScreen.OptimizeListScreen> {
            LaggyListScreen(
                onSuccess = {
                    navController.navigate(NavScreen.ExactLocation)
                }
            )
        }
        composable<NavScreen.ExactLocation> {
            ExactLocation(
                onSuccess = {
                    navController.navigate(NavScreen.StoneScissorsPaper)
                }
            )
        }
        composable<NavScreen.StoneScissorsPaper> {
            StoneScissorsPaperScreen(
                onSuccess = {
                    navController.navigate(NavScreen.Finish)
                }
            )
        }
        composable<NavScreen.Finish> {
            Finish()
        }
    }
}