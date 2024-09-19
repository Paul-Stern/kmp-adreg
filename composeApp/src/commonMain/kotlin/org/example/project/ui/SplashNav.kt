package org.example.project.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.example.project.navigation.SplashNavigation

@Composable
internal fun SplashNav(
    navigateToMain: () -> Unit,
) {
    val navigator = rememberNavController()
    NavHost(
        navController = navigator,
        modifier = Modifier.fillMaxSize(),
        startDestination = SplashNavigation.Splash.route
    ) {}
}