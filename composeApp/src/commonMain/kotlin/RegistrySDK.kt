package org.example.project.db

import business.core.db.User
import org.example.project.db.common.Database
import org.example.project.db.common.DatabaseDriverFactory
import kotlin.jvm.Throws

class RegistrySDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val db = Database(databaseDriverFactory)

    @Throws(Exception::class)
    suspend fun getUsers(forceReload: Boolean): List<User> {
        val cachedUsers = db.getAllUsers()
        return if (cachedUsers.isNotEmpty() && !forceReload) {
            cachedUsers
        } else {
            db.getAllUsers() // TODO: logic seems broken see LN13
        }
    }

    //    /*
    @Throws(Exception::class)
    suspend fun getUser(
        name: String,
        forceReload: Boolean
    ): User {
        val user = db.getUserByName(name)
        return user
    }

//     */
}