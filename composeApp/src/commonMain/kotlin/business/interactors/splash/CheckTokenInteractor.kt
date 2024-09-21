package business.interactors.splash

import business.core.AppDataStore
import business.core.DataState
import business.core.ProgressBarState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CheckTokenInteractor(
    private val appDataStoreManager: AppDataStore,
) {


    /*
    fun execute(): Flow<DataState<Boolean>> = flow {

        try {

            emit(DataState.Loading(progressBarState = ProgressBarState.ButtonLoading))


            val token = appDataStoreManager.readValue(DataStoreKeys.TOKEN) ?: "" // TODO: implement DataStoreKeys




            val isTokenValid = token.isNotEmpty()


            emit(DataState.Data(isTokenValid))

        } catch (e: Exception) {
            e.printStackTrace()
            emit(handleUseCaseException(e)) // TODO: implement handleUseCaseException

        } finally {
            emit(DataState.Loading(progressBarState = ProgressBarState.Idle))
        }


    }


     */
}