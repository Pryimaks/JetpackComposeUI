package com.first.testingjetpackcompose

sealed class Routes(val route: String) {
    object Login: Routes("LoginPageScreen")

    object Home: Routes("LandingPageScreen")

    object SignUp: Routes("SignUpPageScreen")

    object HomeScreen: Routes("HomeScreen")

    object MainScreenSplash: Routes("MainScreenSplash")

    object MovieScreen: Routes("MovieScreen")

    object HomeCalculator: Routes("HomeCalculator")

    object ScreenDetailsContent: Routes("ScreenDetailsContent")
}