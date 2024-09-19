package org.example.project.ui.main.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.navigation.HomeNavigation

// see: https://github.com/razaghimahdi/Shopping-By-KMP/blob/fe055734130d24461c6340f104666a083f7413a1/shared/src/commonMain/kotlin/presentation/ui/main/home/HomeNav.kt#L21:w


@Composable
fun HomeNav(
    logout: () -> Unit,
) {
    val navigator = rememberNavController()

    NavHost(
        startDestination = HomeNavigation.Home.route,
        navController = navigator,
    ) {

        composable(route = HomeNavigation.Home.route) {
            // TODO: Create HomeViewModel
//            val viewModel: HomeViewModel = TODO()
//            HomeScreen(TODO())
        }
    }
}