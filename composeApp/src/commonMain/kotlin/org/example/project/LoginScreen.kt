package org.example.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun LoginScreen() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var login by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }
        Column(
            Modifier.fillMaxHeight().fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Авторизация")
            LoginField(
                value = login,
                onValueChange = { login = it }
            )
            PasswordField(
                value = pass,
                onValueChange = { pass = it }
            )

        }
    }
}