package com.first.testingjetpackcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Content(

    val id: Int,
    val title: String,
    val desc: String

)

const val EXPANSION_ANIMATION_DURATION = 300

const val LOREM_TEXT =
    "Q W E R T Y U I O P A S D F G H J K L. Z X C V B N M."

val contentList = listOf(
    Content(0, "Title one", LOREM_TEXT),
    Content(1, "Title two", LOREM_TEXT),
    Content(2, "Title three", LOREM_TEXT),
    Content(3, "Title four", LOREM_TEXT),
    Content(4, "Title five", LOREM_TEXT)
)

@Composable
fun ExpandableCard(
    content: Content,
    expanded: Boolean,
    onClickExpanded: (id: Int) -> Unit
){

    val transition = updateTransition(targetState = expanded, label = "transition")

    val iconRotationDeg by transition.animateFloat(
        label = "icon change"

    ) {
        state ->

        if(state){
            0f
        } else {
            180f
        }

    }

    val color by transition.animateColor(
        label = "color change"
    ) {
state ->
        if (state){
            Color.Black.copy(.4f)
        } else {
            Color.LightGray
        }

    }


    Card(
        colors = CardDefaults.cardColors(
            containerColor = color
        )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = content.title
                )

                Icon(

                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    modifier = Modifier
                        .rotate(iconRotationDeg)
                        .clickable {
                            onClickExpanded(content.id)
                        }

                )

            }

            Spacer(modifier = Modifier.size(16.dp))

            ExpandableContent(
                isExpanded = expanded,
                desc = content.desc
            )

        }

    }


}


@Composable
fun ExpandableContent(
    isExpanded: Boolean,
    desc: String
){

    val enterTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(EXPANSION_ANIMATION_DURATION)
        ) + fadeIn(
            initialAlpha = .3f,
            animationSpec =  tween(EXPANSION_ANIMATION_DURATION)
        )
    }

    val exitTransition = remember {
        shrinkVertically(
            shrinkTowards = Alignment.Top,
            animationSpec = tween(EXPANSION_ANIMATION_DURATION)
        ) + fadeOut(
            animationSpec =  tween(EXPANSION_ANIMATION_DURATION)
        )
    }

    AnimatedVisibility(
        visible = isExpanded,
        enter = enterTransition,
        exit = exitTransition
    ) {

        Text(
            text = desc,
            textAlign = TextAlign.Justify
        )

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenDetailsContent(

){
    var expandedItem by remember {
        mutableStateOf(-1)
    }

    LazyColumn(

    ) {

        items(contentList){
            content ->
            ExpandableCard(
                content = content,
                expanded = expandedItem == content.id,
                onClickExpanded = {
                    id ->
                    expandedItem = if (expandedItem == id){
                        -1
                    } else {
                        id
                    }
                }
            )
        }

    }

}
