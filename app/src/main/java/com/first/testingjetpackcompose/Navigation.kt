package com.first.testingjetpackcompose

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


enum class SplashState{
    Shown,
    Completed
}


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

        composable(Routes.MainScreenSplash.route) {
            MainScreenSplash(navController = navController)
        }

        composable(Routes.MovieScreen.route){
            MovieScreen()
        }

    }
}

@Composable
fun MainScreenSplash(navController: NavHostController) {
    val transitionState = remember {
        MutableTransitionState(SplashState.Shown)
    }

    val transition = updateTransition(
        transitionState = transitionState,
        label = "Splash Screen"
    )

    val splashAlpha by transition.animateFloat(
        transitionSpec = { tween(100) },
        label = "Splash Alpha"
    ) {
        if (it == SplashState.Shown) 1f else 0f

    }

    val contentAlpha by transition.animateFloat(
        transitionSpec = { tween(300) },
        label = "Content Alpha"
    ) {
        if (it == SplashState.Shown) 0f else 1f

    }

    Box{

        LandingPage(
            modifier = Modifier.alpha(splashAlpha)
        ){
            transitionState.targetState = SplashState.Completed
        }

        ContentScreen(
            modifier = Modifier.alpha(contentAlpha)
        )

    }

}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier = Modifier.size(200.dp),
            color = Color.Green
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = null
            )

        }

    }
}
