package com.first.testingjetpackcompose.foodia.foodiathemeui.details.components

import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Modifier.diagonalGradientBorder(

    colors: List<Color>,
    borderSize: Dp = 2.dp,
    shape: Shape

) =  this.border(
    width = borderSize,
    brush = Brush.linearGradient(colors),
    shape = shape
)