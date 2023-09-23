package com.github.mcgalanes.groomr.core.ui.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun ColumnScope.VerticalSpacer(space: Dp) = Spacer(Modifier.height(space))

@Composable
fun RowScope.HorizontalSpacer(space: Dp) = Spacer(Modifier.width(space))
