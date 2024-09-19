package org.example.project.navigation

sealed class MainNavigation(
    route: String,
) {
    data object Home : MainNavigation (
        route = "Home"
    )
}