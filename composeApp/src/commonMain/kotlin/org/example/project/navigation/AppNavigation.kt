package org.example.project.navigation

import androidx.navigation.NamedNavArgument
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.app_name
import kotlinproject.composeapp.generated.resources.login_screen
import kotlinproject.composeapp.generated.resources.registry
import org.jetbrains.compose.resources.StringResource

enum class AppNavigationOld (val title: StringResource) {
    //    Start(title = Res.string.app_name)
    Splash(title = Res.string.app_name),
    Login(title = Res.string.login_screen),
    Registry(title = Res.string.registry)
}

sealed class AppNavigation(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    data object Splash : AppNavigation(
        route = "Splash",
        arguments = emptyList()
    )

    data object Login : AppNavigation(
        route = "Login",
        arguments = emptyList()
    )
    data object Main : AppNavigation(
        route = "Main",
        arguments = emptyList(),
    )
}

