package org.christophertwo.gallery.presentation.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

@Composable
fun Modifier.picturePlaceholder(): Modifier {
    val transition = rememberInfiniteTransition(label = "placeholder animation")
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "placeholder animation"
    )

    val brush = Brush.linearGradient(
        listOf(
            colorScheme.onSurface.copy(alpha = 0.1f),
            colorScheme.onSurface.copy(alpha = 0.2f),
            colorScheme.onSurface.copy(alpha = 0.1f)
        ),
        start = Offset.Zero,
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        ),
    )

    return this.then(
        Modifier
            .fillMaxSize()
            .background(
                brush = brush
            )
    )
}

