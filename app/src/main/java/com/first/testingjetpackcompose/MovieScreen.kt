package com.first.testingjetpackcompose


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MovieScreen() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (
            menuButton, coverImage, titleText, genreText, ratingText,
            castText, castContainer, castImage1, castImage2, castImage3,
            castImage4, descText
        ) = createRefs()

        Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = null,
            modifier = Modifier.constrainAs(menuButton){
                top.linkTo(parent.top, 36.dp)
                start.linkTo(parent.start, 36.dp)

            }
        )

        val endGuideline = createGuidelineFromStart(.4f)

        Image(
            painter = painterResource(id = R.drawable.baseline_lock_24),
            contentDescription = null,
            modifier = Modifier.constrainAs(coverImage){
                start.linkTo(parent.start, 24.dp)
                top.linkTo(menuButton.bottom, 16.dp)
                end.linkTo(endGuideline, 16.dp)
                width = Dimension.fillToConstraints
            }
                .aspectRatio(2f / 3f)
        )

        Text(
            text = "Iron Man 3",
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 35.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(titleText){
                top.linkTo(menuButton.bottom, 8.dp)
                start.linkTo(coverImage.end, 16.dp)
            }
        )

        Text(
            text = "Action | 2h 10m",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.constrainAs(genreText){
                top.linkTo(titleText.bottom)
                start.linkTo(coverImage.end, 16.dp)
            }
        )

        Text(
            text = "IMDb 7.1 / 10",
            fontWeight = FontWeight.Medium,
            modifier = Modifier.constrainAs(ratingText){
                top.linkTo(genreText.bottom)
                start.linkTo(coverImage.end, 16.dp)
            }
        )

        Text(
            text = "CAST",
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.constrainAs(castText){
                bottom.linkTo(castContainer.top)
                start.linkTo(coverImage.end, 16.dp)
            }
        )

        ConstraintLayout(
            modifier = Modifier.constrainAs(castContainer){
                bottom.linkTo(coverImage.bottom)
                start.linkTo(coverImage.end, 16.dp)
                end.linkTo(parent.end, 16.dp)
                width = Dimension.fillToConstraints
            }

        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_lock_24),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(50.dp)
                    .constrainAs(castImage1){
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(coverImage.end, 16.dp)
                    }.aspectRatio(1f)
            )

            Image(
                painter = painterResource(id = R.drawable.baseline_person_24),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(50.dp)
                    .constrainAs(castImage2){
                        top.linkTo(castImage1.top)
                        bottom.linkTo(castImage1.bottom)
                        end.linkTo(castImage1.end)

                    }
                    .aspectRatio(1f)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(50.dp)
                    .background(Color.Gray)
                    .constrainAs(castImage3){
                        top.linkTo(castImage1.top)
                        bottom.linkTo(castImage1.bottom)
                        end.linkTo(castImage2.end)

                    }
                    .aspectRatio(1f)
            )

            Box(
                modifier = Modifier
                    .height(50.dp)
                    .background(Color.Gray)
                    .constrainAs(castImage4){
                        top.linkTo(castImage1.top)
                        bottom.linkTo(castImage1.bottom)
                        end.linkTo(parent.end)
                        start.linkTo(castImage3.end)
                    }
                    .aspectRatio(1f)

            )
            {
                Text(
                    text = "+9",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .align(Alignment.Center),
                    color = Color.Black
                )
            }

            createHorizontalChain(
                castImage1,
                castImage2,
                castImage3,
                castImage4,
                chainStyle = ChainStyle.SpreadInside
            )


        }

        val barrier = createBottomBarrier(coverImage, castContainer)

        Text(
            text = stringResource(id = R.string.movie_description),
            color = Color.DarkGray,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Justify,
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(descText){
                top.linkTo(barrier, 36.dp)
                start.linkTo(parent.start, 24.dp)
                end.linkTo(parent.end, 24.dp)
                width = Dimension.preferredWrapContent
            }
        )


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PrevMovieScreen(

){
    MovieScreen(

    )

}