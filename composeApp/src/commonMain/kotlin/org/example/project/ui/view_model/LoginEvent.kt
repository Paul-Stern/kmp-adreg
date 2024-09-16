package org.example.project.ui.view_model

sealed class LoginEvent {


    data class OnUpdateNameRegister(val value: String) : LoginEvent()
    data class OnUpdateUsernameLogin(val value: String) : LoginEvent()
    data class OnUpdatePasswordLogin(val value: String) : LoginEvent()

    data object Register : LoginEvent()
    data object Login : LoginEvent()
    data object OnRemoveHeadFromQueue : LoginEvent()
/*
    data class Error(
        val uiComponent: UIComponent
    ) : LoginEvent()


    data object OnRetryNetwork : LoginEvent()
    data class OnUpdateNetworkState(
        val networkState: NetworkState
    ): LoginEvent()

 */
}
