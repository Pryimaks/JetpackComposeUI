package com.first.testingjetpackcompose

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class MultiFloatingState{
    Expanded,
    Collapsed
}

enum class Identifier{
    Attachment,
    Camera,
    Note
}

class MinFabItem(
    val icon: Painter,
    val label: String,
    val identifier: String
)

@Composable
fun MainScreen(

){

    var multiFloatingState by remember {
        mutableStateOf(MultiFloatingState.Collapsed)
    }

    val context = LocalContext.current

    val items = listOf(
        MinFabItem(
            icon = painterResource(id = R.drawable.baseline_lock_24),
            label = "Attachment",
            identifier = Identifier.Attachment.name
        ),
        MinFabItem(
            icon = painterResource(id = R.drawable.baseline_person_24),
            label = "Camera",
            identifier = Identifier.Camera.name
        ),
        MinFabItem(
            icon = painterResource(id = R.drawable.ic_launcher_foreground),
            label = "Note",
            identifier = Identifier.Note.name
        )
    )

    MultiFloatingButton(
        multiFloatingState = multiFloatingState,
        onMultiFabStateChange = { multiFloatingState = it },
        items = items,
        context = context
    )



}

@Composable
fun MultiFloatingButton(
    multiFloatingState: MultiFloatingState,
    onMultiFabStateChange: (MultiFloatingState) -> Unit,
    context: Context,
    items: List<MinFabItem>

){
    val transition = updateTransition(targetState = multiFloatingState,
        label = "transition")

    val rotate by transition.animateFloat(label = "rotate") {
        if (it == MultiFloatingState.Expanded) 315f else 0f

    }

    val fabScale by transition.animateFloat(
        label = "FabScale"
    ){
        if(it == MultiFloatingState.Expanded) 36f else 0f
    }

    val alpha by transition.animateFloat(
        label = "alpha",
        transitionSpec = {tween(durationMillis = 50)}
    ){
        if(it == MultiFloatingState.Expanded) 1f else 0f

    }

    val textShadow by transition.animateDp(
        label = "textShadow",
        transitionSpec = {tween(durationMillis = 50)}
    ){
        if(it == MultiFloatingState.Expanded) 2.dp else 0.dp

    }

    Column(
        horizontalAlignment = Alignment.End

    ) {
        if (transition.currentState == MultiFloatingState.Expanded){
            items.forEach {
                MinFab(
                    item = it,
                    onMinFabItemClick = { minFabItem ->
                        when(minFabItem.identifier){
                            Identifier.Attachment.name -> {
                                Toast.makeText(
                                    context, "Attachment",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                            Identifier.Camera.name -> {
                                Toast.makeText(
                                    context, "Camera",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            Identifier.Note.name -> {
                                Toast.makeText(
                                    context, "Note",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    },
                    alpha = alpha,
                    textShadow = textShadow,
                    fabScale = fabScale,
                )
                Spacer(modifier = Modifier.size(6.dp))
            }
        }

        FloatingActionButton(
            onClick = {
                onMultiFabStateChange(
                    if (transition.currentState == MultiFloatingState.Expanded) {
                        MultiFloatingState.Collapsed
                    } else {
                        MultiFloatingState.Expanded
                    }
                )

            }
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.rotate(rotate)
            )

        }
    }
}

@Composable
fun MinFab(
    item: MinFabItem,
    alpha: Float,
    textShadow: Dp,
    fabScale: Float,
    showLabel: Boolean = true,
    onMinFabItemClick: (MinFabItem) -> Unit,


    ){
    val buttonColor = MaterialTheme.colorScheme.secondary

    val shadow = Color.Black.copy(5f)

    val interactionSource = remember { MutableInteractionSource() }

    Row {
if(showLabel){
        Text(
            text = item.label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .alpha(
                    animateFloatAsState(
                        targetValue = alpha,
                        animationSpec = tween(50)
                    ).value
                )
                .shadow(textShadow)
                .background(MaterialTheme.colorScheme.surface)
                .padding(start = 6.dp, end = 6.dp, top = 4.dp)
        )}

        Spacer(modifier = Modifier.size(16.dp))

        Box(
            modifier = Modifier.size(32.dp).clickable(
                interactionSource = interactionSource,
                onClick = {
                    onMinFabItemClick.invoke(item)
                },
                indication = rememberRipple(
                    bounded = false,
                    radius = 20.dp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
            ).background(buttonColor, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = item.icon,
                contentDescription = item.label,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}