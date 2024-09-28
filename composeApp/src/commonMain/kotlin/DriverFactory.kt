package org.example.project.db

import app.cash.sqldelight.db.SqlDriver

interface DriverFactory {
    fun createDriver(): SqlDriver
}