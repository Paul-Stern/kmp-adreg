package business.interactors.splash

import business.core.AppDataStore
import business.core.DataState
import business.datasource.network.splash.SplashService
import kotlinx.coroutines.flow.Flow

class LoginInteractor(
    private val service: SplashService,
    private val appDataStoroManager: AppDataStore
) {
    fun execute(
        email: String,
        password: String,
    ) = {TODO()}}
//    ): Flow<DataState<String>> = flow { // TODO: implement DataState
/*
        try {

            emit(DataState.Loading(progressBarState = ProgressBarState.ButtonLoading))

            val apiResponse = service.login(email, password)



            apiResponse.alert?.let { alert ->
                emit(
                    DataState.Response(
                        uiComponent = UIComponent.Dialog(
                            alert = alert
                        )
                    )
                )
            }


            val result = apiResponse.result


            if (result != null) {
                appDataStoreManager.setValue(
                    DataStoreKeys.TOKEN,
                    AUTHORIZATION_BEARER_TOKEN + result
                )
                appDataStoreManager.setValue(
                    DataStoreKeys.EMAIL,
                    email
                )
            }


            emit(DataState.Data(result, apiResponse.status))

        } catch (e: Exception) {
            e.printStackTrace()
            emit(handleUseCaseException(e))

        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }


    }

}
 */
