package com.first.testingjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay

@Composable
fun LandingPage(
    modifier: Modifier = Modifier,
    onTimeOut:() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ){
        val currentTimeOut by rememberUpdatedState(newValue = onTimeOut)

        LaunchedEffect(key1 = Unit) {
            delay(2000)
            currentTimeOut.invoke()
        }

        Image(
            painter = painterResource(id = R.drawable.baseline_person_24),
            contentDescription = null
        )

    }

}