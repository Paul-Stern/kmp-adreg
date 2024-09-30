package org.example.project.db.common

import business.core.db.User
import org.example.project.db.AppDatabase

internal class Database (dbDriverFactory: DatabaseDriverFactory) {
    private val db = AppDatabase(dbDriverFactory.createDriver())
    private val dbQuery = db.appDatabaseQueries

    internal fun getTestUser(): User {
        return dbQuery.selectTestUser(::mapUserSelecting).executeAsOne()
    }
//    /*
    internal fun getAllUsers(): List<User> {
        return dbQuery.selectAllUsers(::mapUserSelecting).executeAsList()
    }
//     */
    private fun mapUserSelecting(
        id: Long,
        login: String,
        pass: String
    ): User {
        return User(
            id = id.toInt(),
            login = login,
            pass = pass
        )
    }
}