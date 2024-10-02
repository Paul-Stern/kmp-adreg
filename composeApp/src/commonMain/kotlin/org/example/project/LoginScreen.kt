package org.example.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import org.example.project.ui.view_model.LoginState
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinproject.composeapp.generated.resources.*
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.auth
import kotlinproject.composeapp.generated.resources.login
import kotlinproject.composeapp.generated.resources.login_screen
import kotlinproject.composeapp.generated.resources.password
import kotlinproject.composeapp.generated.resources.registry
import org.example.project.ui.view_model.LoginEvent
import org.jetbrains.compose.resources.painterResource
import org.example.project.db.RegistrySDK

// Taken from:
// https://github.com/JetBrains/compose-multiplatform/blob/a6961385ccf0dee7b6d31e3f73d2c8ef91005f1a/examples/nav_cupcake/composeApp/src/commonMain/kotlin/org/jetbrains/nav_cupcake/CupcakeScreen.kt#L50

enum class RegistryScreen (val title: StringResource) {
//    Start(title = Res.string.app_name),
    Login(title = Res.string.login_screen),
    Registry(title = Res.string.registry)
}

// Taken from
// https://github.com/JetBrains/compose-multiplatform/blob/a6961385ccf0dee7b6d31e3f73d2c8ef91005f1a/examples/nav_cupcake/composeApp/src/commonMain/kotlin/org/jetbrains/nav_cupcake/CupcakeScreen.kt#L89

@Composable
@Preview
fun LoginScreen(
    state: LoginState,
    events: (LoginEvent) -> Unit,
    navigateToMain: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = RegistryScreen.valueOf(
        backStackEntry?.destination?.route ?: RegistryScreen.Login.name
    )

    LaunchedEffect(state.navigateToMain) {
        if (state.navigateToMain) {
             navigateToMain() // TODO: Wait until implemented in App.kt
        }
    }

    var showContent by remember { mutableStateOf(false) }
    var login by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    // TODO: add login button
    MaterialTheme {
        Column(
            Modifier.fillMaxHeight().fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(Res.string.auth))
            LoginField(
                value = login,
                onValueChange = {
                    login = it
                    state.usernameLogin = login
                }
            )
            PasswordField(
                value = pass,
                onValueChange = {
                    pass = it
                    state.passwordLogin = pass
                },
                onDone = { // TODO: see LoginViewModel
                    if (loginPairOk(state)){
                        navigateToMain()
                    }
                }
            )

        }
    }
}
@Preview
@Composable
fun LoginField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it)},
        label = { Text(stringResource(resource = Res.string.login)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        )
    )
}
@Preview
@Composable
fun PasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit, // maybe next time
) {
    val isPasswordVisible = remember { mutableStateOf(false) }
    val callback = {} // TODO: write a callback t workaround login
    TextField(
        value = value,
        onValueChange = { onValueChange(it)},
        label = { Text(stringResource(resource = Res.string.password)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password,
        ),
        keyboardActions = KeyboardActions(onDone = {
            onDone()
        }), // TODO: fire a Login event
        visualTransformation = when (isPasswordVisible.value) {
            true -> VisualTransformation.None
            false -> PasswordVisualTransformation()
        },
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible.value = !isPasswordVisible.value
            }) {
                   when (isPasswordVisible.value) {
                       true -> Icon(
                           painter = painterResource(Res.drawable.ic_password_hide),
                           contentDescription = null,
                           tint = MaterialTheme.colorScheme.primary
                       )
                       false -> Icon(
                           painter = painterResource(Res.drawable.ic_password_show),
                           contentDescription = null,
                           tint = MaterialTheme.colorScheme.surfaceTint // TODO: choose a color
                       )
            }
            }
        }
    )
}

fun loginPairOk(state: LoginState): Boolean {
   return state.usernameLogin == "test" && state.passwordLogin == "test"
}