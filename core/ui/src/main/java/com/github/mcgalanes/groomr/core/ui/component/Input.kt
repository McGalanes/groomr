package com.github.mcgalanes.groomr.core.ui.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.token.shape.squircle.SquircleShape

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
) {
    TextField(
        modifier = modifier,
        placeholder = { Text(text = placeholder ?: "") },
        shape = SquircleShape(24.dp),
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
    )
}
