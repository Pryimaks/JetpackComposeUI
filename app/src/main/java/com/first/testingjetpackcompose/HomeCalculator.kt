package com.first.testingjetpackcompose

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.first.testingjetpackcompose.ui.theme.CalculatorTheme


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.clearCompositionErrors

import androidx.compose.ui.draw.clip

import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.first.testingjetpackcompose.ui.theme.LightGrey


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeCalculator(calculatorViewModel: CalculatorViewModel?){

    val uiState = calculatorViewModel?.uiState
    val contentMargin = 16.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightGrey)
                .padding(contentMargin),
                verticalArrangement = Arrangement.SpaceBetween,

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End

            ) {
                Spacer(modifier = Modifier.size(250.dp))
                Text(
                    text = uiState?.infix ?: "-20+60/-5*(20-5)",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Black
                )

                Spacer(modifier = Modifier.size(contentMargin))

                Text(
                    text = uiState?.result ?: "-200",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(modifier = Modifier.size(contentMargin))

            }


        }

Column{
    Spacer(modifier = Modifier.size(350.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.size(contentMargin))


            CharacterItem(
                char = "(",
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f, true)
            ) {
                calculatorViewModel?.onInfixChange("(")

            }

            Spacer(modifier = Modifier.size(contentMargin))

            CharacterItem(
                char = ")",
                modifier = Modifier
                    .padding(4.dp)
                    .weight(1f, true)
            ) {
                calculatorViewModel?.onInfixChange(")")

            }

            Spacer(modifier = Modifier.size(contentMargin))

        }

        Spacer(modifier = Modifier.size(contentMargin))



        Row {
            val numbers = listOf(
                "7", "8", "9", "4", "5",
                "6", "1", "2", "3", "0",
                ".", "C"
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.weight(1f),

            ) {
                items(numbers) { number ->

                    CharacterItem(
                        char = number,
                        modifier = Modifier
                            .padding(contentMargin)
                    ) {
                        if (number != "C") {
                            calculatorViewModel?.onInfixChange(number)
                        } else {
                            calculatorViewModel?.clearInfixExpression()
                        }

                    }
                }

            }


            ConstraintLayout(
                modifier = Modifier
                    .weight(0.8f)
            ) {

                val (
                    addition, multiplication,
                    division, minus, power, equal
                ) = createRefs()

                CharacterItem(
                    char = "-",
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(minus) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(division.start)
                            bottom.linkTo(addition.top)

                        }
                        .aspectRatio(1f),
                    color = MaterialTheme.colorScheme.secondary
                ) {

                    calculatorViewModel?.onInfixChange("-")

                }


                CharacterItem(
                    char = "/",
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(division) {
                            top.linkTo(parent.top)
                            start.linkTo(minus.end, contentMargin)
                            end.linkTo(parent.end, contentMargin)

                        }
                        .aspectRatio(1f),
                    color = MaterialTheme.colorScheme.secondary
                ) {

                    calculatorViewModel?.onInfixChange("/")

                }


                CharacterItem(
                    char = "*",
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(multiplication) {
                            top.linkTo(division.bottom, contentMargin)
                            start.linkTo(addition.end)
                            end.linkTo(parent.end)
                            bottom.linkTo(power.top)

                        }
                        .aspectRatio(1f),
                    color = MaterialTheme.colorScheme.secondary
                ) {

                    calculatorViewModel?.onInfixChange("*")

                }


                CharacterItem(
                    char = "^",
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(power) {
                            top.linkTo(multiplication.bottom, contentMargin)
                            start.linkTo(addition.end, contentMargin)
                            end.linkTo(parent.end, contentMargin)
                            bottom.linkTo(equal.top)

                        }
                        .aspectRatio(1f),
                    color = MaterialTheme.colorScheme.secondary
                ) {

                    calculatorViewModel?.onInfixChange("^")

                }


                CharacterItem(
                    char = "+",
                    modifier = Modifier
                        .width(50.dp)
                        .constrainAs(addition) {
                            top.linkTo(minus.bottom, contentMargin)
                            start.linkTo(parent.start)
                            end.linkTo(multiplication.start)
                            bottom.linkTo(equal.top, contentMargin)

                        }
                        .aspectRatio(1f / 2f),
                    color = MaterialTheme.colorScheme.secondary
                ) {

                    calculatorViewModel?.onInfixChange("+")

                }


                CharacterItem(
                    char = "=",
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(equal) {
                            top.linkTo(power.bottom, contentMargin)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end, contentMargin)
                            bottom.linkTo(parent.bottom)

                        }
                        .aspectRatio(2f / 1f),
                    color = MaterialTheme.colorScheme.secondary
                ) {

                    calculatorViewModel?.evaluateExpression()

                }


            }


        }
    }

    }




@Composable
fun CharacterItem(
    char: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.surface,
    onClick: () -> Unit

) {

    Surface(
        shape = CircleShape,
        color = color,
        modifier = modifier
            .clip(CircleShape)
            .clickable {
                onClick.invoke()
            }
    ) {

        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = char,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrevHomeCalculator(){
    CalculatorTheme{
        HomeCalculator(calculatorViewModel = null)
    }
}