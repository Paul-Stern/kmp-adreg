package org.example.project.ui.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel(
//    private val loginInteractor: LoginInteractor, // NB TODO: implement
) : ViewModel() {

    val state: MutableState<LoginState> = mutableStateOf(LoginState())

}