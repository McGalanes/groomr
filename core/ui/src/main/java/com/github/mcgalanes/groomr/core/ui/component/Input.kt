package com.github.mcgalanes.groomr.core.ui.component

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Input(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    singleLine: Boolean = true,
) {
    OutlinedTextField(
        modifier = modifier,
        placeholder = { Text(text = placeholder ?: "") },
        value = value,
        singleLine = singleLine,
        onValueChange = onValueChange,
    )
}
