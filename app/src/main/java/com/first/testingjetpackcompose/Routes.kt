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

    object NestedNavigation: Routes("NestedNavigation")

    object QuotesScreen: Routes("QuotesScreen")

    object MyNavigation: Routes("MyNavigation")

    object Feed: Routes("Feed")
}