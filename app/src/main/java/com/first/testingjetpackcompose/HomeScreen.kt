package com.first.testingjetpackcompose

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


enum class ScreenType{
    Summary,
    Detail,
    SummaryWithDetail
}

@Composable
fun HomeScreen(
    windowSize: WindowSize,
    navController: NavHostController

){
    val isExpanded = windowSize == WindowSize.Expanded

    var index by remember {
        mutableStateOf(0)
    }

    var isItemOped by remember {
        mutableStateOf(false)
    }

    val homeScreenType = getScreenType(
        isExpanded = isExpanded,
        isDetailOpened = isItemOped
    )

    val color = listOf(
        Color.Blue,
        Color.Green,
        Color.Yellow,
        Color.Red,
        Color.Cyan,
        Color.Magenta,
        Color.Gray,
        Color.DarkGray,
        Color.Black,
        Color.LightGray
    )

    when(homeScreenType){

        ScreenType.Detail -> {
            DetailScreen(color = color[index]) {
                isItemOped = false

            }
        }

        ScreenType.Summary -> {
            SummaryScreen(items = color,
                onItemSelected = {
                    index = it
                    isItemOped = true
                })

        }

        ScreenType.SummaryWithDetail -> {
            SummaryWithDetailScreen(
                items = color,
                index = index,
                onIndexChange = {
                    index = it
                }
            )

        }

    }

}


@Composable
fun SummaryScreen(
    items: List<Color>,
    onItemSelected: (index: Int) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        contentPadding = PaddingValues(top = 8.dp)){
        itemsIndexed(items){
            index, item ->
            
            SummaryItem(
                color = item
            ) { 
                onItemSelected.invoke(index)
            }

        }
    }


}

@Composable
fun DetailScreen(
    color: Color,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
){
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        DetailItem(color = color)

    }
    BackHandler {
        onBackPressed.invoke()
    }

}

@Composable
fun DetailItem(color: Color){
    Surface(
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(8.dp)
    ) {

    }
}

@Composable
fun SummaryItem(
    color: Color, onItemSelected: (index: Int) -> Unit
){
    Surface(
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(8.dp)
            .clickable {
                onItemSelected.invoke(0)
            },
    ){

    }
}

@Composable
fun SummaryWithDetailScreen(
    items: List<Color>,
    index: Int,
    onIndexChange: (Int) -> Unit
){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround

    ){
        SummaryScreen(
            items = items,
            onItemSelected = onIndexChange,
            modifier = Modifier.width(334.dp)
        )

        DetailScreen(
            color = items[index]
        ) {

        }

    }

}


@Composable
fun getScreenType(
    isExpanded: Boolean,
    isDetailOpened: Boolean
): ScreenType = when(isExpanded) {
    false -> {
        if (isDetailOpened){
            ScreenType.Detail
        } else {
            ScreenType.Summary
        }
    }

        true -> {
            ScreenType.SummaryWithDetail

        }
}

