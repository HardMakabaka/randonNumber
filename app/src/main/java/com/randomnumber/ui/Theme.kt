package com.randomnumber.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Black = Color(0xFF000000)
private val DarkGray = Color(0xFF121212)
private val MediumGray = Color(0xFF1E1E1E)
private val LightGray = Color(0xFF2C2C2C)
private val AccentGreen = Color(0xFF00E676)
private val AccentGreenDark = Color(0xFF00C853)
private val TextPrimary = Color(0xFFFFFFFF)
private val TextSecondary = Color(0xFFB3B3B3)

private val DarkColorScheme = darkColorScheme(
    primary = AccentGreen,
    onPrimary = Black,
    primaryContainer = LightGray,
    onPrimaryContainer = TextPrimary,
    secondary = AccentGreenDark,
    onSecondary = Black,
    secondaryContainer = LightGray,
    onSecondaryContainer = TextPrimary,
    tertiary = AccentGreen,
    background = Black,
    onBackground = TextPrimary,
    surface = DarkGray,
    onSurface = TextPrimary,
    surfaceVariant = MediumGray,
    onSurfaceVariant = TextSecondary,
    error = Color(0xFFCF6679),
    onError = Black
)

@Composable
fun RandomNumberTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        content = content
    )
}
