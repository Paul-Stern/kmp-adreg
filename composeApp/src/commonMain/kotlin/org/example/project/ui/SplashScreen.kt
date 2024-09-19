package org.example.project.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import org.example.project.ui.view_model.LoginState
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun SplashScreen(
    state: LoginState,
//    events: (LoginEvent) -> Unit,
    navigateToMain: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    LaunchedEffect(state.navigateToMain) {
        delay(3000L)
        if (state.navigateToMain) {
            navigateToMain()
        } else {
            navigateToLogin()
        }
    }

}