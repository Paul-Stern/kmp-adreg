package org.example.project.navigation

import androidx.navigation.NamedNavArgument

sealed class HomeNavigation(
    val route: String,
    val args: List<NamedNavArgument>
){
    data object Home : HomeNavigation(
        route = "Home",
        args = emptyList()
    )
}