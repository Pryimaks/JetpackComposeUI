package com.first.testingjetpackcompose.ui.theme.signup

import android.inputmethodservice.Keyboard
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.first.testingjetpackcompose.ui.theme.components.HeaderText
import com.first.testingjetpackcompose.ui.theme.components.LoginTextField
import kotlin.math.sin

@Composable
fun SignUpScreen(

    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
    onPolicyClick: () -> Unit,
    onPrivacyClick: () -> Unit

){

    val (firstName, onFirstNameChange) =
        rememberSaveable {
        mutableStateOf("")
    }

    val (lastName, onLastNameChange) =
        rememberSaveable {
            mutableStateOf("")
        }

    val (email, onEmailChange) =
        rememberSaveable {
            mutableStateOf("")
        }

    val (password, onPasswordChange) =
        rememberSaveable {
            mutableStateOf("")
        }

    val (confirmPassword, onConfirmPasswordChange) =
        rememberSaveable {
            mutableStateOf("")
        }

    val (agree, onAgreeChange) =
        rememberSaveable {
            mutableStateOf(false)
        }

    val context = LocalContext.current

    var isPasswordSame by remember {
        mutableStateOf(false)
    }

    val isFieldsNotEmpty = firstName.isNotEmpty() && lastName.isNotEmpty()
            && email.isNotEmpty() && password.isNotEmpty()
            && confirmPassword.isNotEmpty() && agree

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        AnimatedVisibility(isPasswordSame) {

            Text(
                "Password Is not Matching",
                color = MaterialTheme.colorScheme.error
            )

        }

        HeaderText(
            text = "Sign up",
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(alignment = Alignment.Start)
        )

        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = firstName,
            onValueChange = onFirstNameChange,
            labelText = "First Name",
            leadingIcon = Icons.Default.Person
        )

        Spacer(Modifier.height(16.dp))

        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = lastName,
            onValueChange = onLastNameChange,
            labelText = "Last Name",
            leadingIcon = Icons.Default.Person
        )

        Spacer(Modifier.height(16.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = onEmailChange,
            labelText = "Email",
            leadingIcon = Icons.Default.Email
        )

        Spacer(Modifier.height(16.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = onPasswordChange,
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            keyboardType = KeyboardType.Password
        )

        Spacer(Modifier.height(16.dp))
        LoginTextField(
            modifier = Modifier.fillMaxWidth(),
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            labelText = "Confirm Password",
            leadingIcon = Icons.Default.Lock,
            keyboardType = KeyboardType.Password
        )

        Spacer(Modifier.height(16.dp))

        Row(

            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {

            val privacyText = "Privacy"
            val policyText = "Policy"
            val annotatedString = buildAnnotatedString {
                withStyle(SpanStyle(
                    color = MaterialTheme
                        .colorScheme.onBackground
                )){

                    append("I Agree with")

                }
                append(" ")

                withStyle(SpanStyle(
                    color = MaterialTheme
                        .colorScheme.primary
                )){

                    pushStringAnnotation(tag =
                    privacyText, privacyText)
                    append(privacyText)

                }
                append(" And ")

                withStyle(SpanStyle(
                    color = MaterialTheme
                        .colorScheme.primary
                )){

                    pushStringAnnotation(tag =
                    policyText, policyText)
                    append(policyText)

                }
                append(" ")


            }

            Checkbox(
                agree, onAgreeChange
            )

            ClickableText(
                annotatedString
            ) {
                offset ->

                annotatedString
                    .getStringAnnotations(
                        offset,
                        offset
                    ).forEach {

                        when(it.tag){
                            privacyText -> {

                                Toast.makeText(
                                    context,
                                    "Privacy Text Clicked",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()

                                onPrivacyClick()

                            }

                            policyText -> {

                                Toast.makeText(
                                    context,
                                    "Policy Text Clicked",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()

                                onPolicyClick()

                            }

                        }

                    }

            }

        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {

                isPasswordSame = password != confirmPassword
                if(!isPasswordSame){
                    onSignUpClick()
                }

            },
            modifier = Modifier
                .fillMaxWidth(),

            enabled = isFieldsNotEmpty

        ){

            Text("Sign Up")

        }

        Spacer(Modifier.height(16.dp))

        val signTx = "Sign In"

        val signInAnnotation = buildAnnotatedString{
            withStyle(
                SpanStyle(
                    color = MaterialTheme
                        .colorScheme.onBackground
                )


            ){
                append("Already have an account?")

            }
            append("  ")

            withStyle(SpanStyle(color =
            MaterialTheme.colorScheme.primary
            )){

                pushStringAnnotation(signTx, signTx)
                append(signTx)

            }

        }

        ClickableText(
            signInAnnotation
        ) {
            offset ->
            signInAnnotation
                .getStringAnnotations(offset, offset)
                .forEach {

                    if (it.tag == signTx) {

                        Toast
                            .makeText(
                                context,
                                "Sign in Clicked",
                                Toast.LENGTH_SHORT
                            )
                            .show()

                        onLoginClick()

                    }
                }

                }

        }
        }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignUpScreen(

){
    SignUpScreen(
        onSignUpClick = {},
        onLoginClick = {},
        onPolicyClick = {},
        onPrivacyClick = {}
    )
}