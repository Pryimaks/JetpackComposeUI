package com.first.testingjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHost
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.first.testingjetpackcompose.screens.auth.ForgotPasswordScreen
import com.first.testingjetpackcompose.screens.auth.LoginScreen
import com.first.testingjetpackcompose.screens.auth.SignUp
import com.first.testingjetpackcompose.screens.home.HomeScreen
import com.first.testingjetpackcompose.screens.home.ScreenOne
import com.first.testingjetpackcompose.screens.home.ScreenTwo


enum class Destinations{
    SIGNUP, LOGIN, FORGOT_PASSWORD,
    HOME_SCREEN, SCREEN_ONE, SCREEN_TWO
}

@Composable
fun Navigation(
    navController: NavHostController,
    isLoggedIn: Boolean
){

    NavHost(
        navController = navController,
        startDestination = Destinations.LOGIN.name
    ){

        composable(Destinations.LOGIN.name){
            LoginScreen(
                onLogin = {
                    navController.navigate(Destinations.HOME_SCREEN.name)
                },
                onSignUp = {
                    navController.navigate(Destinations.SIGNUP.name)
                },
                onForgotPassword = {
                    navController.navigate(Destinations.FORGOT_PASSWORD.name)
                }
            )
        }

        composable(Destinations.FORGOT_PASSWORD.name){
            ForgotPasswordScreen{
                navController.navigate(Destinations.HOME_SCREEN.name)
            }
        }

        composable(Destinations.SIGNUP.name){
            SignUp{
                navController.navigate(Destinations.HOME_SCREEN.name)
            }

        }

        composable(Destinations.HOME_SCREEN.name){
            HomeScreen(
                onNavigateToScreenOne = {
                    navController.navigate(Destinations.SCREEN_ONE.name)
                },
                onNavigateToScreenTwo = {
                    navController.navigate(Destinations.SCREEN_TWO.name)
                }
            )

        }

        composable(Destinations.SCREEN_ONE.name){
            ScreenOne{
                navController.navigateUp()
            }
        }

        composable(Destinations.SCREEN_TWO.name){
            ScreenTwo{
                navController.navigateUp()
            }
        }

    }

    LaunchedEffect(Unit) {
        if(!isLoggedIn){
            navController.navigate(Destinations.LOGIN.name)
        }
    }

}