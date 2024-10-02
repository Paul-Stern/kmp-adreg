package di

import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.project.ui.view_model.LoginViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.KoinContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun appModule() = module{
    factory { LoginViewModel(dbSDK = get()) }
} // TODO: Add context later?

// see: https://github.com/muazkadan/CMP-News-App/blob/main/composeApp/src/commonMain/kotlin/di/Koin.kt
fun viewModelModule() =
    module {
//        viewModelOf(::BasicViewModel)
    }