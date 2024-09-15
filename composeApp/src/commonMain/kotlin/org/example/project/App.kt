@file:OptIn(ExperimentalFoundationApi::class)

package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var login by remember { mutableStateOf("") }
        var pass by remember { mutableStateOf("") }
        Column(
            Modifier.fillMaxHeight().fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            /*
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
            */
            TextField(
                value = login,
                onValueChange = { login = it },
            )
            Spacer(Modifier.height(16.dp))
            PasswordTextField()
            /*
            BasicSecureTextField(
                value = pass,
                onValueChange = { pass = it },
            )
             */
        //            TextField()
        }
    }
}

@Preview
@Composable
fun LoginField() {
    var login by remember { mutableStateOf("") }
}

@Preview
@Composable
fun PasswordTextField() {
    var passHidden by rememberSaveable{ mutableStateOf("") }
    BasicSecureTextField(
        value = passHidden,
        onValueChange = {passHidden = it},
    )
}