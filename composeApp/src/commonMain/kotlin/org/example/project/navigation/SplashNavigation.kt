package org.example.project.navigation

import androidx.navigation.NamedNavArgument
import kotlin.jvm.JvmSerializableLambda

sealed class SplashNavigation(
    val route: String,
    val args: List<NamedNavArgument>
) {
    data object Splash : SplashNavigation(
        "Splash",
        emptyList()
    )
    data object Login : SplashNavigation(
        "Login",
        emptyList()
    )
}