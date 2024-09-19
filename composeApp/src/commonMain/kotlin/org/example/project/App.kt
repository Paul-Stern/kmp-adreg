@file:OptIn(ExperimentalFoundationApi::class)

package org.example.project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.navigation.AppNavigation
import org.example.project.ui.splash.SplashNav

@Composable
fun App() {
//    LoginScreen(LoginState()) // TODO: Implement navigateToMain():
    // TODO: Complete splash screen
    // SEE: SplashScreen.kt file
    MaterialTheme {
        val navigator = rememberNavController()

        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navigator,
                startDestination = AppNavigation.Splash.route, // Fix: unknown parameter
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = AppNavigation.Splash.route) {
//                    SplashNav // TODO:
                    SplashNav(
                        navigateToMain = {
                            navigator.popBackStack()
//                            navigator.navigate(AppNavigation.Login.route)
//                            navigator.navigate(AppNavigation.Main.route) // TODO: Create Main route
                        }
                    )
                }
            }
        }

//         */

//        SplashScreen()
        /*
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
        //            healthcareSplash(
        //                resource = imageResource(Res.drawable)
        //            )
                Column {
                    Text(text = stringResource(Res.string.company))
                    Text(text = stringResource(Res.string.app_name))
                }
            }
         */
    }

}

/*
@Composable
fun healthcareSplash(resource: DrawableResource): ImageVector {

}

 */