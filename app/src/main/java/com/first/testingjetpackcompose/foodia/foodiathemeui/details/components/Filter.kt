package com.first.testingjetpackcompose.foodia.foodiathemeui.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.first.testingjetpackcompose.foodia.model.Filter


@Composable
fun FilterBar(

    filter: List<Filter>,
    onShowFilters: () -> Unit

    ) {

    LazyRow(

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 12.dp, end = 8.dp),
        modifier = Modifier.heightIn(min = 56.dp)

    ) {

        item {
            IconButton(
                onClick = {}
            ) {

                Surface(
                    modifier = Modifier
                ) {

                }

            }
        }

    }

}