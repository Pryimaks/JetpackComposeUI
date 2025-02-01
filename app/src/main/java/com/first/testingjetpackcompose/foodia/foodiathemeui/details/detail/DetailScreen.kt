package com.first.testingjetpackcompose.foodia.foodiathemeui.details.detail

import android.media.Image
import android.telecom.Call.Details
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.first.testingjetpackcompose.DetailItem
import com.first.testingjetpackcompose.R
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.components.FoodCollectionComp
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.components.FoodImage
import com.first.testingjetpackcompose.foodia.foodiathemeui.details.components.QuantitySelector
import com.first.testingjetpackcompose.foodia.model.FoodCollection
import com.first.testingjetpackcompose.foodia.model.FoodItem
import com.first.testingjetpackcompose.foodia.model.FoodRepo
import retrofit2.http.Body
import java.math.BigDecimal
import java.text.NumberFormat
import kotlin.math.max
import kotlin.math.min


private val BottomBarHeight = 56.dp

private val TitleHeight = 128.dp

private val GradientScroll = 180.dp

private val ImageOverlap = 115.dp

private val MinTitleOffset = 56.dp

private val MinImageOffset = 12.dp

private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll

private val ExpandedImageSize = 300.dp

private val CollapsedImageSize = 150.dp

private val HzPadding = Modifier.padding(horizontal = 24.dp)


@Composable
fun FoodDetail(

    foodId: Long,
    upPress: () -> Unit

){

    val food = remember(key1 = foodId){

        FoodRepo.getFoodById(foodId)

    }

    val related = remember(key1 = foodId) {

        FoodRepo.getRelated(foodId)

    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val scroll = rememberScrollState(0)
        Header()

        Body(
            related = related,
            scroll = scroll
        )

        Title(foodItem = food){
            scroll.value
        }

        Image(imageUrl = food.imageUrl){
            scroll.value
        }

        Up(upPress)

        DetailBottomBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )




    }

}

@Composable
private fun Up(upPress: () -> Unit){
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
    ) {

        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = ""
        )

    }
}


@Composable
private fun Image(

    imageUrl: String,
    scrollProvider: () -> Int

){

    val collapseRange = with(LocalDensity.current){

        (MaxTitleOffset - MinTitleOffset).toPx()

    }

    val collapseFractionProvider = {
        (scrollProvider() / collapseRange).coerceIn(0f, 1f)
    }

    CollapsingImageLayout(
        collapseFractionProvide = collapseFractionProvider,
        modifier = HzPadding.then(Modifier.statusBarsPadding())
    ) {

        FoodImage(imageUrl = imageUrl,
            contentDescription = null)

    }

}


@Composable
private fun CollapsingImageLayout(

    collapseFractionProvide: () -> Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit

){

    Layout(content = content, modifier = modifier){
        measurable, constraints ->

        check(measurable.size == 1)
        val collapseFraction = collapseFractionProvide()
        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = lerp(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurable[0].measure(Constraints.fixed(imageWidth, imageWidth))

        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = lerp(
            (constraints.maxWidth - imageWidth) / 2,
            constraints.maxWidth - imageWidth,
            collapseFraction
        )
        
        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth
        ){
            imagePlaceable.placeRelative(imageX, imageY)
        }


    }

}


@Composable
private fun Title(
    foodItem: FoodItem,
    scrollProvider: () -> Int
){

    val maxOffest = with(LocalDensity.current){
        MaxTitleOffset.toPx()
    }

    val minOffest = with(LocalDensity.current){
        MinTitleOffset.toPx()
    }

    Column(

        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .offset {

                val scroll = scrollProvider()
                val offset = (maxOffest - scroll)
                    .coerceAtLeast(minOffest)
                IntOffset(x = 0, y = offset.toInt())

            }

    ) {

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = foodItem.name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = HzPadding
        )

        Text(
            text = foodItem.tagline,
            style = MaterialTheme.typography.displayMedium,
            modifier = HzPadding,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = formatPrice(foodItem.price),
            style = MaterialTheme.typography.headlineMedium,
            modifier = HzPadding
        )

        Spacer(modifier = Modifier.height(8.dp))



    }



}


@Composable
private fun Header(

){

    Spacer(modifier = Modifier
        .height(280.dp)
        .fillMaxWidth())

}


@Composable
private fun Body(

    related: List<FoodCollection>,
    scroll: ScrollState

){
    Column {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )

        Column(
        modifier = Modifier
            .verticalScroll(scroll)
    ) {

        Spacer(
            modifier = Modifier
                .height(GradientScroll)
        )

        Surface(
            Modifier.fillMaxWidth()
        ) {
            Column {

                Spacer(
                    modifier = Modifier
                        .height(ImageOverlap)
                )
                Spacer(
                    modifier = Modifier
                        .height(TitleHeight)
                )
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )

                Text(

                    text = "Details",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = HzPadding

                )

                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )


                var seeMore by remember {
                    mutableStateOf(true)
                }

                Text(
                    text = stringResource(id = R.string.detail_placeholder),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (seeMore) 5 else Int.MAX_VALUE,
                    overflow = TextOverflow.Ellipsis,
                    modifier = HzPadding
                )

                val textBtn = if (seeMore) "See More"
                else "See less"

                Text(

                    text = textBtn,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .heightIn(20.dp)
                        .fillMaxWidth()
                        .padding(top = 15.dp)
                        .clickable {
                            seeMore = !seeMore
                        }

                )

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "Ingredients",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = HzPadding
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = stringResource(id = R.string.ingredients_list),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = HzPadding
                )

                Spacer(modifier = Modifier.height(16.dp))

                Divider()
                related.forEach { foodCollection ->

                    key(foodCollection.id) {
                        FoodCollectionComp(
                            foodCollection = foodCollection,
                            onFoodClick = {},
                            highlight = false
                        )
                    }

                }

                Spacer(
                    modifier = Modifier
                        .padding(bottom = BottomBarHeight)
                        .navigationBarsPadding()
                        .height(8.dp)
                )

            }

        }

    }

}

}


@Composable
private fun DetailBottomBar(
    modifier: Modifier = Modifier
){

    var (count, updateCount) = remember {
        mutableIntStateOf(1)
    }

    Surface(
        modifier
    ) {
        Column{
            Divider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .navigationBarsPadding()
                    .then(HzPadding)
                    .heightIn(min = BottomBarHeight)
            ){

                QuantitySelector(
                    count = count,
                    decreaseItemCount =
                    { if (count > 0) updateCount(count - 1) },
                    increaseItemCount =
                    { updateCount(count + 1) },
                )

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = "ADD TO CART",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        maxLines = 1
                    )
                }



            }
        }
    }

}


@Composable
fun formatPrice(price: Long): String{
    return NumberFormat.getCurrencyInstance()
        .format(BigDecimal(price).movePointLeft(2))
}































































