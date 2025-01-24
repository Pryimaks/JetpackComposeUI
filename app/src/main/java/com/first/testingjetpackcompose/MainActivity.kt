package com.first.testingjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.first.testingjetpackcompose.pagination.QuotesScreen
import com.first.testingjetpackcompose.ui.theme.TestingJetpackComposeTheme
import com.first.testingjetpackcompose.ui.theme.login.LoginScreen


class MainActivity : ComponentActivity() {

    val viewModel by viewModels<CalculatorViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setOnExitAnimationListener{
            splashScreenView ->

            splashScreenView.iconView.apply{
                animate().apply {
                    duration = 300
                    scaleXBy(-5f)
                    scaleYBy(-5f)
                    alpha(0f)
                    withEndAction {
                        splashScreenView.remove()
                    }
                }
            }
        }


        setContent {
            //
        // Navigation()
            val navController = rememberNavController()
            MyNavigation(
                navHostController = navController
            )
           // LoginScreen()
/*
            val quotesViewModel: QuotesViewModel by viewModels()
            val quotesPagingItems = quotesViewModel.quotes.collectAsLazyPagingItems()
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){

                QuotesScreen(quotesPagingItems)

            }

 */

            //MainScreen()

          //  LandingPageScreen()


            /*
            TestingJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )


                }


            }

             */
        }

    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingJetpackComposeTheme {
        Greeting("Android")
    }
}