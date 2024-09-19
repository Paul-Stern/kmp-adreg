package org.example.project.navigation

sealed class MainNavigation(
    val route: String,
) {
    data object Home : MainNavigation (
        route = "Home",
    )
}