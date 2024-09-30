package org.example.project.ui.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import business.interactors.splash.LoginInteractor

class LoginViewModel(
//    private val loginInteractor: LoginInteractor, // NB TODO: implement
//    private val checkTokenInteractor: CheckTokenInteractor, // TODO: implement
) : ViewModel() {

    val state: MutableState<LoginState> = mutableStateOf(LoginState())

    // TODO: finish LoginViewModel

    fun onTriggerEvent(event: LoginEvent) { // TODO: Call it somewhere
        when (event) {

            is LoginEvent.OnUpdateNameRegister -> {
                TODO()
            }

            is LoginEvent.Login -> {
                TODO()
            }

            is LoginEvent.OnUpdatePasswordLogin -> {
                onUpdatePasswordLogin(event.value)
            }
            else -> {
                TODO()
            }

        }
    }


    private fun onUpdatePasswordLogin(value: String) {
        state.value = state.value.copy(passwordLogin = value)
    }

    /*
    private fun onUpdateNameRegister(value: String) {
        state.value = state.value.copy(nameRegister = value)
    }

     */


    /*
    private fun checkToken() {
        checkTokenInteractor.execute().onEach { dataState ->
            when (dataState) {
                is DataState.NetworkStatus -> {}
                is DataState.Response -> {
                    onTriggerEvent(LoginEvent.Error(dataState.uiComponent))
                }

                is DataState.Data -> {
                    state.value = state.value.copy(isTokenValid = dataState.data ?: false)
                    state.value = state.value.copy(navigateToMain = dataState.data ?: false)
                }

                is DataState.Loading -> {
                    state.value =
                        state.value.copy(progressBarState = dataState.progressBarState)
                }
            }
        }.launchIn(viewModelScope)
    }
     */
}