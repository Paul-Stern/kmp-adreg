package org.example.project.ui.view_model

data class LoginState(
    val usernameLogin: String = "",
    val passwordLogin: String = "",

    val navigateToMain: Boolean = false,
)