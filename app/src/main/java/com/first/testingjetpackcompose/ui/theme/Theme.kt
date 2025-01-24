package com.first.testingjetpackcompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF0A9396),
    onPrimary = Color.White,
    secondary = Color(0xFF005F73),
    onSecondary = Color.White,
    background = Color(0xFFEDF6F9),
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    tertiary = Brown
)

// Dark color palette
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF94D2BD),
    onPrimary = Color.Black,
    secondary = Color(0xFF0A9396),
    onSecondary = Color.Black,
    background = Color(0xFF001219),
    onBackground = Color.White,
    surface = Color(0xFF003549),
    onSurface = Color.White,
    tertiary = Brown
)

@Composable
fun CalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(
            bodyLarge = MaterialTheme.typography.bodyLarge.copy(
                color = colorScheme.onBackground
            ),
            titleLarge = MaterialTheme.typography.titleLarge.copy(
                color = colorScheme.primary
            )
        ),
        content = content
    )
}

@Composable
fun TestingJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}