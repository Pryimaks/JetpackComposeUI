package com.first.testingjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.first.testingjetpackcompose.ui.theme.Blue
import com.first.testingjetpackcompose.ui.theme.SignUpState

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
                    .padding(20.dp)

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
                    modifier = Modifier.size(240.dp)
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
                        navController.navigate(Routes.HomeCalculator.route)

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {

                    Text(text = "Calculator",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )

                }

                Spacer(modifier = Modifier.size(16.dp))

                Button(

                    onClick = {
                        navController.navigate(Routes.MovieScreen.route)

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {

                    Text(text = "Movie Screen Constraint Layout",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )

                }

                Spacer(modifier = Modifier.size(16.dp))

                Button(

                    onClick = {
                        navController.navigate(Routes.MainScreenSplash.route)

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {

                    Text(text = "Splash Screen First Type",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )

                }

                Spacer(modifier = Modifier.size(16.dp))

                MainScreen()

                Spacer(modifier = Modifier.size(16.dp))

                Button(

                    onClick = {
                        navController.navigate(Routes.HomeScreen.route)

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {

                    Text(text = "All Screen Support Sizes",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )

                }

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
                    onClick = { navController.navigate(Routes.SignUp.route) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = buttonColors(Color.Cyan)

                ) {
                    Text(text = "Sign up",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                        )

                }

                Spacer(modifier = Modifier.size(16.dp))

                Button(

                    onClick = {
                        navController.navigate(Routes.ScreenDetailsContent.route)

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {

                    Text(text = "Screen Details Content",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )

                }

                Spacer(modifier = Modifier.size(16.dp))

                Button(

                    onClick = {
                        navController.navigate(Routes.NestedNavigation.route)

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {

                    Text(text = "Nested Navigation",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )

                }

                Spacer(modifier = Modifier.size(16.dp))

                Button(

                    onClick = {
                        navController.navigate(Routes.MyNavigation.route)

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {

                    Text(text = "LoginAndSignUpSystem Navigation",
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold
                    )

                }

                Spacer(modifier = Modifier.size(16.dp))

                Button(

                    onClick = {
                        navController.navigate(Routes.Feed.route)

                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium

                ) {

                    Text(text = "Feed",
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
                    onClick = { navController.navigate(Routes.SignUp.route) }
                ) {
                    Text(text = "Sign up")

                }

            }

        }


    }

}



//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPageScreen(navController: NavHostController) {
    val signUpState = SignUpState()
    Surface(
        color = Color.Blue,
        contentColor = Color.Yellow,
        modifier = Modifier.fillMaxSize()
    ) {
        
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)){
                OutlinedTextField(
                    value = signUpState.firstName,
                    onValueChange = { signUpState.firstNameChange(it) },
                    modifier = Modifier.weight(1f),
                    shape = MaterialTheme.shapes.medium,
                    label = { Text(text = "First Name") }
                )
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedTextField(
                    value = signUpState.lastName,
                    onValueChange = { signUpState.lastNameChange(it) },
                    modifier = Modifier.weight(1f),
                    shape = MaterialTheme.shapes.medium,
                    label = { Text(text = "Last Name") }
                )
            }

            OutlinedTextField(
                value = signUpState.emailAddress,
                onValueChange = { signUpState.emailAddressChange(it) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Email Address") }
            )
            Spacer(modifier = Modifier.size(8.dp))

            OutlinedTextField(
                value = signUpState.password,
                onValueChange = { signUpState.password(it) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            OutlinedTextField(
                value = signUpState.confirmPassword,
                onValueChange = { signUpState.confirmPasswordChange(it) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Confirm Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier.padding(horizontal = 16.dp)

            ) {
                Checkbox(
                    checked = signUpState.checked,
                    onCheckedChange = {signUpState.checkedChange(it)}
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "Agree with privacy policy")

            }
            Spacer(modifier = Modifier.size(8.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium

            ) {
                Text(text = "Sign Up")

            }

            Row(modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
                .wrapContentSize(align = Alignment.BottomCenter)){
                Text(text = "Already have an account?")
                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "Sign In",
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.Login.route)
                    },
                    color = MaterialTheme.colorScheme.primary
                )
            }

        }

    }
}
