package com.first.testingjetpackcompose

sealed class Routes(val route: String) {
    object Login: Routes("LoginPageScreen")

    object Home: Routes("LandingPageScreen")

    object SignUp: Routes("SignUpPageScreen")
}