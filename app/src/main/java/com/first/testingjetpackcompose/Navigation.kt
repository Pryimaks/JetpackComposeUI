package com.first.testingjetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


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

    }
}
