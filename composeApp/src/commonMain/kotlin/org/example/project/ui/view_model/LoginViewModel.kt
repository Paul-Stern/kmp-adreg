package org.example.project.ui.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel(
//    private val loginInteractor: LoginInteractor, // TODO: implement
) : ViewModel() {

    val state: MutableState<LoginState> = mutableStateOf(LoginState())

}