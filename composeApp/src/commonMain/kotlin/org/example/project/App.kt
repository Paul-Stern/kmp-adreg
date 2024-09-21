@file:OptIn(ExperimentalFoundationApi::class)

package org.example.project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.application
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import di.appModule
import org.example.project.navigation.AppNavigation
import org.example.project.ui.main.MainNav
import org.example.project.ui.splash.SplashNav
import org.koin.compose.KoinApplication
import org.koin.core.context.KoinContext
import org.koin.dsl.koinApplication
import javax.lang.model.type.NullType
import javax.naming.Context

fun koinConfiguration() = koinApplication {
    modules()
}

@Composable
//internal fun App(context: Context) { // TODO: Create common.context to use here
internal fun App() {
    // see: https://insert-koin.io/docs/reference/koin-compose/compose/#koin-compose-multiplatform-vs-koin-android-jetpack-compose
    KoinApplication(application = {
        modules(appModule()) // TODO: add context
    }) {
        // paired with LN64
    }
//    LoginScreen(LoginState()) // TODO: Implement navigateToMain():
    // TODO: Complete splash screen
    // SEE: SpashScreen.kt file
    MaterialTheme {
        val navigator = rememberNavController()

        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navigator,
                startDestination = AppNavigation.Splash.route, // Fix: unknown parameter
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = AppNavigation.Splash.route) {
                    SplashNav(
                        navigateToMain = {
                            navigator.popBackStack()
//                            navigator.navigate(AppNavigation.Login.route)
                            navigator.navigate(AppNavigation.Main.route)
                        }
                    )

//                 */
                }
                composable(route = AppNavigation.Main.route) {
                    MainNav { // TODO: implement it
                        navigator.popBackStack()
                        navigator.navigate(AppNavigation.Splash.route)
                    }
                }
            }
        }
    }
}
//}