@file:OptIn(ExperimentalFoundationApi::class)

package org.example.project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.app_name
import kotlinproject.composeapp.generated.resources.company
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import org.example.project.navigation.AppNavigation
import org.example.project.ui.view_model.LoginState
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
//    LoginScreen(LoginState()) // TODO: Implement navigateToMain():
    // TODO: Complete splash screen
    // SEE: SpashScreen.kt file
    MaterialTheme {
        val navigator = rememberNavController()

        /*
        Box(modifier = Modifier.fillMaxSize()) {
            NavHost(
                navController = navigator,
                graph = AppNavigation.Splash

//                graph =
//                modifier = Modifier.fillMaxSize(),
            )
        }

         */

        SplashScreen()
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