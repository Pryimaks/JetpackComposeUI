package com.first.testingjetpackcompose.foodia.foodiathemeui.details.navigation

import android.telecom.Call.Details
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.detail.FoodDetail
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.home.Feed
import com.first.testingjetpackcompose.navigation.Destinations

const val DetailRoute = "DetailScreen"

enum class Tabs(
    val title: String,
    val icon: ImageVector,
    val route: String
){
    Feed("Home", Icons.Outlined.Home, "home/feed"),
    Cart("Cart", Icons.Outlined.ShoppingCart, "home/cart")
}

@Composable
fun FoodiaNavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String
){

    NavHost(navController = navController,
        startDestination = startDestination) {

        composable(Tabs.Feed.route){
            Feed(onFoodClick = {
                navController.navigate("$DetailRoute/$it")
            })
        }

        composable(
            route = "$DetailRoute/{id}",
            arguments = listOf(navArgument("id"){

            })
        ){
            from ->

            val id = from.arguments?.getString("id") ?: "1"
            FoodDetail(foodId = id.toLong()) {
                navController.navigateUp()
            }
        }

    }


}

