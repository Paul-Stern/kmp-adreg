package di

import androidx.lifecycle.viewmodel.compose.viewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.KoinContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

fun appModule(context: KoinContext) = module{}

// see: https://github.com/muazkadan/CMP-News-App/blob/main/composeApp/src/commonMain/kotlin/di/Koin.kt
fun viewModelModule() =
    module {
//        viewModelOf(::BasicViewModel)
    }