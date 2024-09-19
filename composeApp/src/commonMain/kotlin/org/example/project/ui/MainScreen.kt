package org.example.project.ui.main

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

//@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun MainScreen() {
    MaterialTheme {
        Text(text = "Главный экран")
    }
}