package com.first.testingjetpackcompose

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.first.testingjetpackcompose.ui.theme.Blue

@Composable
fun LoginHomeScreen(navController: NavHostController) {
    //LandingPageScreen(navController)

}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LandingPageScreen(
    navController: NavController, modifier: Modifier = Modifier
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
                    onClick = {
                        navController.navigate(Routes.Login.route)

                    },
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
                    onClick = { navController.navigate(Routes.Register.route) },
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

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPageScreen(navController: NavHostController) {
    Surface(
        color = Color.Blue,
        contentColor = Color.Yellow,
        modifier = Modifier.fillMaxSize()
    ) {

        val (username, onUserNameChange) = remember {
            mutableStateOf("")
        }

        val (password, onPasswordChange) = remember {
            mutableStateOf("")
        }

        val (checked, onCheckedChange) = remember {
            mutableStateOf(false)
        }

        Column(

        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = onUserNameChange,
                label = { Text(text = "UserName") },
                leadingIcon = { Icon(painter = painterResource(id =
                R.drawable.baseline_person_24),
                contentDescription = null) },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text(text = "Password") },
                leadingIcon = { Icon(painter = painterResource(id =
                R.drawable.baseline_lock_24),
                    contentDescription = null) },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Row{
                    Checkbox(
                        checked = checked,
                        onCheckedChange = onCheckedChange
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Remember your password")
                }

                TextButton(
                    onClick = {  }
                ) {
                    Text(text = "Forgot password")

                }

            }

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) { 
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.BottomCenter,
                        )

            ){
                Text(text = "Don't have an account?")

                TextButton(
                    onClick = { navController.navigate(Routes.Register.route) }
                ) {
                    Text(text = "Sign up")

                }

            }

        }


    }

}

@Composable
fun RegisterPageScreen(navController: NavHostController) {
    Surface(
        color = Color.Blue,
        contentColor = Color.Yellow,
        modifier = Modifier.fillMaxSize()
    ) {

        val (username, onUserNameChange) = remember {
            mutableStateOf("")
        }

        val (password, onPasswordChange) = remember {
            mutableStateOf("")
        }

        val (checked, onCheckedChange) = remember {
            mutableStateOf(false)
        }

        Column(

        ) {
            Text(
                text = "Register",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = onUserNameChange,
                label = { Text(text = "UserName") },
                leadingIcon = { Icon(painter = painterResource(id =
                R.drawable.baseline_person_24),
                    contentDescription = null) },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(modifier = Modifier.size(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text(text = "Password") },
                leadingIcon = { Icon(painter = painterResource(id =
                R.drawable.baseline_lock_24),
                    contentDescription = null) },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                shape = MaterialTheme.shapes.medium
            )

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                Row{
                    Checkbox(
                        checked = checked,
                        onCheckedChange = onCheckedChange
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Remember your password")
                }

                TextButton(
                    onClick = {  }
                ) {
                    Text(text = "Forgot password")

                }

            }

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Register")
            }

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.BottomCenter)

            ){
                Text(text = "Already have an account?")

                TextButton(
                    onClick = { navController.navigate(Routes.Login.route) }
                ) {
                    Text(text = "Sign In")

                }

            }

        }



    }
}
