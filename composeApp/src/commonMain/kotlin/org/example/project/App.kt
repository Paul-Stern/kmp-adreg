@file:OptIn(ExperimentalFoundationApi::class)

package org.example.project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.example.project.ui.view_model.LoginState
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview

fun App() {
//    LoginScreen(LoginState()) // TODO: Implement navigateToMain():
    // TODO: Complete splash screen
    MaterialTheme {
        val navigator = rememberNavController()

        Box(modifier = Modifier.fillMaxSize()) {

        }
    }
}