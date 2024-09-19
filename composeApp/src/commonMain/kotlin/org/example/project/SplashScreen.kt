package org.example.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.app_name
import kotlinproject.composeapp.generated.resources.company
import kotlinx.coroutines.delay
import org.example.project.ui.view_model.LoginEvent
import org.example.project.ui.view_model.LoginState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
internal fun SplashScreen(
    state: LoginState,
//    events: (LoginEvent) -> Unit,
//    navigateToMain: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    LaunchedEffect(state.navigateToMain) {
        delay(3000L)
        navigateToLogin()
    }
    MaterialTheme {
        val navigator = rememberNavController()

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
    }
}