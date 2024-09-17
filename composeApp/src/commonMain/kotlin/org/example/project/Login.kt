package org.example.project

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.ExperimentalResourceApi
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.login
import kotlinproject.composeapp.generated.resources.password
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
//import org.jetbrains.compose.resources

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
) {
    val isPasswordVisible = remember { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = { onValueChange(it)},
        label = { Text(stringResource(resource = Res.string.password)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password,
        ),
        visualTransformation = when (isPasswordVisible.value) {
            true -> VisualTransformation.None
            false -> PasswordVisualTransformation()
        }
    )
}
//fun stringResource(resource: StringResource): String{}