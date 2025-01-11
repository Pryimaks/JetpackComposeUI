package com.first.testingjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.first.testingjetpackcompose.ui.theme.Blue
import com.first.testingjetpackcompose.ui.theme.Yellow

@Composable
fun LoginHomeScreen(

){

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LandingPageScreen(

){
    Surface(color = Color.Yellow) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    val path = Path()
                    val x = size.width
                    val y = size.height
                    val center = size.center
                    path.apply {
                        moveTo(0f, 0f)
                        lineTo(x, 0f)

                        cubicTo(
                            x1 = x,
                            y1 = center.y / 2,
                            x2 = x,
                            y2 = center.y,
                            x3 = 0f,
                            y3 = center.y
                        )

                    }

                    drawPath(path = path, color = Blue)

                }

        ) {
            Column(
                modifier = Modifier
                    .padding(50.dp)

            ) {
                Text(
                    text = "Hello everyone",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 30.sp,
                    color = Color.White,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = "Welcome to Pryivers",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.size(340.dp)
                )

            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp)
                    .wrapContentSize(align = Alignment.BottomCenter)

            ) {

                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {
                    Text(text = "Sign In",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                        )

                }

                Spacer(modifier = Modifier.size(16.dp))

                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = buttonColors(Color.Cyan)

                ) {
                    Text(text = "Sign up",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                        )

                }


            }

        }
    }
}