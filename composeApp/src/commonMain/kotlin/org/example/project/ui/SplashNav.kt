package org.example.project.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.navigation.SplashNavigation
import org.example.project.ui.SplashScreen
import org.example.project.ui.view_model.LoginViewModel
import org.koin.compose.koinInject

@Composable
internal fun SplashNav(
    viewModel: LoginViewModel = koinInject(),
    navigateToMain: () -> Unit,
) {
    val navigator = rememberNavController()
    NavHost(
        navController = navigator,
        modifier = Modifier.fillMaxSize(),
        startDestination = SplashNavigation.Splash.route
    ) {
        composable(SplashNavigation.Splash.route) {
            // TODO: implement LoginViewModel
            // See: https://github.com/razaghimahdi/Shopping-By-KMP/blob/fe055734130d24461c6340f104666a083f7413a1/shared/src/commonMain/kotlin/presentation/ui/splash/SplashNav.kt#L27C1-L27C47
//            /*
             SplashScreen(
                 viewModel.state.value,
                 navigateToMain = navigateToMain,
                 navigateToLogin = {
                     navigator.popBackStack()
                     navigator.navigate(SplashNavigation.Login.route)
                 }
                 ) // TODO
//             */


        }
    }
}