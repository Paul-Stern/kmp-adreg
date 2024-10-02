package org.example.project.ui.view_model

data class LoginState(
    var usernameLogin: String = "",
    var passwordLogin: String = "",

    val navigateToMain: Boolean = false,
)