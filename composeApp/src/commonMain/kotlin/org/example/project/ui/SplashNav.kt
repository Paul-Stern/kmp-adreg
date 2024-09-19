package org.example.project.ui.splash

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
internal fun SplashNav(
    navigateToMain: () -> Unit,
) {
    val navigator = rememberNavController()
}