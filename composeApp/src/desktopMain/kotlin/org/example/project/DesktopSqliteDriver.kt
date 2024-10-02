package org.example.project.db.common

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.example.project.db.AppDatabase

// see: https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/#constructing-driver-instances

//import org.example.Use

class DesktopDriverFactory: DatabaseDriverFactory {
    override fun createDriver(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        AppDatabase.Schema.create(driver)
        return driver
    }
}

