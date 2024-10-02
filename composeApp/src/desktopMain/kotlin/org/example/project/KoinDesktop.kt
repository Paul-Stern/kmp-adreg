package org.example.project

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import org.example.project.db.RegistrySDK
import org.example.project.db.common.DatabaseDriverFactory
import org.example.project.db.common.DesktopDriverFactory
import org.koin.dsl.module
import java.util.prefs.Preferences

/*
actual val platformModule = module {
    single {
        Preferences.userRoot()
    }
    single<Settings> {
        PreferencesSettings(get())
    }
}
 */
/* TODO: see https://www.jetbrains.com/help/kotlin-multiplatform-dev/multiplatform-ktor-sqldelight.html#build-an-sdk
// and generally the article
val appModule = module {
    single<RegistrySDK> {
        RegistrySDK(
            databaseDriverFactory = DesktopDriverFactory()
        )
    }
}

 */