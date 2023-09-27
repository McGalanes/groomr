package com.github.mcgalanes.groomr.feature.userstory.create.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.mcgalanes.groomr.core.ui.GroomrTheme

@Preview
@Composable
private fun TitleInputPreview() {
    GroomrTheme {
        var value by remember { mutableStateOf("") }

        TitleInput(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            placeholder = "Your title here...",
            onValueChange = { value = it },
        )
    }
}

@Composable
fun TitleInput(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val contentColor = MaterialTheme.colorScheme.onPrimaryContainer

    BasicTextField(
        modifier = modifier,
        textStyle = MaterialTheme.typography.headlineSmall
            .copy(color = contentColor),
        cursorBrush = SolidColor(contentColor),
        value = value,
        onValueChange = onValueChange,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.height(44.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (value.isBlank()) {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.headlineSmall,
                        color = contentColor.copy(alpha = .5f),
                    )
                }
                innerTextField()
            }
        },
    )
}
