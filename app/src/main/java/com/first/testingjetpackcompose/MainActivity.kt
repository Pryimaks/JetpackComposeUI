package com.first.testingjetpackcompose

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.components.FoodCollectionComp
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.detail.FoodDetail
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.home.Feed
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.navigation.FoodiaNavigationHost
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.navigation.Tabs
import com.first.testingjetpackcompose.pagination.QuotesScreen
import com.first.testingjetpackcompose.ui.theme.TestingJetpackComposeTheme
import com.first.testingjetpackcompose.ui.theme.login.LoginScreen


class MainActivity : ComponentActivity() {

    val viewModel by viewModels<CalculatorViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
/*
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

 */

        setContent {
            TestingJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodiaApp()
                    /*
                    FoodDetail(
                        foodId = 2
                    ) {

                    }

                     */

                }
            }
            //
       // Navigation()
            //

            /*
            val navController = rememberNavController()
            MyNavigation(
                navHostController = navController
            )

             */






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


    @Composable
    fun FoodiaApp(){

        val navController = rememberNavController()

        Scaffold {
            paddingValues ->

            FoodiaNavigationHost(
                modifier = Modifier
                    .padding(paddingValues),
                navController = navController,
                startDestination = Tabs.Feed.route
            )

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

