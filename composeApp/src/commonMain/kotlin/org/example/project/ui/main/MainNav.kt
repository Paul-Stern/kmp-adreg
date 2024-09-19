package org.example.project.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.example.project.navigation.MainNavigation

@Composable
fun MainNav(logout: () -> Unit) {
    // see: https://github.com/razaghimahdi/Shopping-By-KMP/blob/fe055734130d24461c6340f104666a083f7413a1/shared/src/commonMain/kotlin/presentation/ui/main/MainNav.kt#L40:w

    val navController = rememberNavController()

    Box() {
        NavHost(
            navController = navController,
            startDestination = MainNavigation.Home.route,
        ) {}
    }
}