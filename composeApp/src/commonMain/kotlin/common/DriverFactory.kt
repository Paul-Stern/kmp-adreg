package org.example.project.db.common

import app.cash.sqldelight.db.SqlDriver

// see: https://cashapp.github.io/sqldelight/2.0.2/multiplatform_sqlite/#constructing-driver-instances

//import org.example.Use

interface DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}