package com.github.mcgalanes.groomr.core.ui.modifier

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.doubleBorder(
    color: Color,
    radius: Dp = 24.dp,
    innerWidth: Dp = 1.dp,
    outerWidth: Dp = 3.dp,
): Modifier = this
    .border(
        width = outerWidth,
        color = color.copy(alpha = .2f),
        shape = RoundedCornerShape(radius + outerWidth),
    )
    .padding(outerWidth)
    .border(
        width = innerWidth,
        color = color,
        shape = RoundedCornerShape(radius),
    )
    .clip(RoundedCornerShape(radius + outerWidth))
