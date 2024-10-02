package org.example.project

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
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