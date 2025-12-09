package com.example.proyecto.ui.theme

import androidx.compose.ui.graphics.Color

// Primary Colors from Landing/HTML
val PrimaryBlue = Color(0xFF13A4EC)
val PrimaryDarkBlue = Color(0xFF005A9C) // from opportunities
val PrimaryTeal = Color(0xFF017A73) // from reports

// Backgrounds
val BackgroundLight = Color(0xFFF6F7F8)
val BackgroundDark = Color(0xFF101C22)

// Surfaces
val SurfaceLight = Color(0xFFFFFFFF)
val SurfaceDark = Color(0xFF1A2831)

// Text
val TextPrimaryLight = Color(0xFF111618)
val TextSecondaryLight = Color(0xFF666666) // or 6C757D
val TextPrimaryDark = Color(0xFFF6F7F8)
val TextSecondaryDark = Color(0xFFA0A7AD)

// Status
val SuccessGreen = Color(0xFF28A745)
val WarningRed = Color(0xFFDC3545)
val WarningYellow = Color(0xFFFFC107)

// Tailwind-like neutrals if needed
val Neutral100 = Color(0xFFF5F5F7)
val Neutral600 = Color(0xFF6C757D)
val Neutral900 = Color(0xFF212529)

val md_theme_light_primary = PrimaryBlue
val md_theme_light_onPrimary = Color.White
val md_theme_light_background = BackgroundLight
val md_theme_light_onBackground = TextPrimaryLight
val md_theme_light_surface = SurfaceLight
val md_theme_light_onSurface = TextPrimaryLight
val md_theme_light_error = WarningRed
val md_theme_light_onError = Color.White

val md_theme_dark_primary = PrimaryBlue
val md_theme_dark_onPrimary = Color.White // or darker text
val md_theme_dark_background = BackgroundDark
val md_theme_dark_onBackground = TextPrimaryDark
val md_theme_dark_surface = SurfaceDark
val md_theme_dark_onSurface = TextPrimaryDark
val md_theme_dark_error = WarningRed // slightly lighter for dark mode usually, but sticking to palette
val md_theme_dark_onError = Color.Black
