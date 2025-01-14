package com.first.testingjetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.dp



@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.route) {

        composable(Routes.Home.route) {
            LandingPageScreen(navController = navController)
        }

        composable(Routes.Login.route) {
            LoginPageScreen(navController = navController)
        }

        composable(Routes.SignUp.route) {
            SignUpPageScreen(navController = navController)
        }

        composable(Routes.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                windowSize = getWindowSizeClass(windowSizeDpSize = DpSize(334.dp, 334.dp))
            )
        }

    }
}
