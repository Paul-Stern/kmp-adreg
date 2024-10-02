package org.example.project

import org.example.project.db.RegistrySDK
import org.example.project.db.common.DesktopDriverFactory
import org.koin.dsl.module

val appModule = module {
    single<RegistrySDK> {
        RegistrySDK(
            databaseDriverFactory = DesktopDriverFactory()
        )
    }
}