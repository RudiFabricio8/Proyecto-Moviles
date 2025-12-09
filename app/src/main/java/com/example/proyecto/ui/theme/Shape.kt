package com.example.proyecto.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp), // 0.25rem
    small = RoundedCornerShape(8.dp),      // 0.5rem (DEFAULT in tailwind config)
    medium = RoundedCornerShape(12.dp),    
    large = RoundedCornerShape(16.dp),     // 1rem (lg)
    extraLarge = RoundedCornerShape(24.dp) // 1.5rem (xl)
)
