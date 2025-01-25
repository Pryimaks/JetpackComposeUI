package com.first.testingjetpackcompose.foodia.foodiathemeui.details.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.first.testingjetpackcompose.foodia.model.Filter
import com.first.testingjetpackcompose.foodia.model.FoodCollection
import com.first.testingjetpackcompose.foodia.model.FoodRepo

@Composable
fun Feed(

    onFoodClick: (Long) -> Unit,
    modifier: Modifier = Modifier

){

    val foodCollection = remember {

        FoodRepo.getFoods()

    }

    val filters = remember {

        FoodRepo.getFilters()

    }

}

@Composable
private fun Feed(

    foodCollection: List<FoodCollection>,
    filters: List<Filter>,
    onFoodClick: (Long) -> Unit,
    modifier: Modifier = Modifier

){

    Surface(

        modifier = modifier.fillMaxSize()

    ) {

        Box(

        ){

        }

    }

}

@Composable
private fun FoodCollectionList(

    foodCollection: List<FoodCollection>,
    filters: List<Filter>,
    onFoodClick: (Long) -> Unit,
    modifier: Modifier = Modifier

){

    var filtersVisible by rememberSaveable {

        mutableStateOf(false)

    }

    Box(

        modifier = modifier

    ){

        LazyColumn(

        ) {
            item {
                Spacer(
                    modifier = Modifier.windowInsetsTopHeight(
                        WindowInsets.statusBars.add(
                            WindowInsets(top = 56.dp)
                        )
                    )
                )
            }
        }

    }

}