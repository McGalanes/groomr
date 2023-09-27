package com.github.mcgalanes.groomr.core.ui

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.github.mcgalanes.groomr.core.ui.component.TransparentSystemBars

private val DarkColorScheme =
    darkColorScheme(
        primary = Green80,
        onPrimary = Color.White,
        primaryContainer = Green10,
        onPrimaryContainer = Color.White,
        inversePrimary = Green40,
        secondary = Blue80,
        onSecondary = Blue20,
        secondaryContainer = Blue10,
        onSecondaryContainer = Color.White,
        tertiary = Blue80,
        onTertiary = Blue20,
        tertiaryContainer = Blue30,
        onTertiaryContainer = Blue90,
        error = Red80,
        onError = Red20,
        errorContainer = Red30,
        onErrorContainer = Red90,
        background = Grey10,
        onBackground = Grey90,
        surface = Grey10,
        onSurface = Grey90,
        inverseSurface = Grey90,
        inverseOnSurface = Grey10,
        surfaceVariant = GreenGrey30,
        onSurfaceVariant = GreenGrey80,
        outline = GreenGrey80,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Green20,
        onPrimary = Color.White,
        primaryContainer = Green30,
        onPrimaryContainer = Color.White,
        inversePrimary = Green80,
        secondary = Blue40,
        onSecondary = Color.White,
        secondaryContainer = Blue20,
        onSecondaryContainer = Blue90,
        tertiary = Blue40,
        onTertiary = Color.White,
        tertiaryContainer = Blue90,
        onTertiaryContainer = Blue10,
        error = Red40,
        onError = Color.White,
        errorContainer = Red90,
        onErrorContainer = Red10,
        background = Color.White,
        onBackground = Grey10,
        surface = Color.White,
        onSurface = Grey10,
        inverseSurface = Grey20,
        inverseOnSurface = Grey95,
        surfaceVariant = GreenGrey90,
        onSurfaceVariant = GreenGrey30,
        outline = GreenGrey50,
    )

@Composable
fun GroomrTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Dynamic color is available on Android 12+
    edgeToEdge: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window

            if (edgeToEdge) {
                WindowCompat.setDecorFitsSystemWindows(
                    window,
                    /* decorFitsSystemWindows = */ false,
                )

                window.navigationBarColor = colorScheme.surface.toArgb()
            } else {
                window.statusBarColor = colorScheme.primary.toArgb()

                WindowCompat.getInsetsController(
                    (view.context as Activity).window,
                    view,
                ).isAppearanceLightStatusBars = darkTheme
            }
        }
    }

    if (edgeToEdge) {
        TransparentSystemBars()
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
