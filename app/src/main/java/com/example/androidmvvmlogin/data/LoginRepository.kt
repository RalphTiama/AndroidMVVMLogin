package com.example.androidmvvmlogin.data

import com.example.androidmvvmlogin.data.model.LoggedInUser
import com.example.androidmvvmlogin.data.remote.LoginDataSource
import javax.inject.Inject


class LoginRepository @Inject constructor(private val dataSource: LoginDataSource) {

    private var user: LoggedInUser? = null

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    suspend fun logout() {
        user = null
        dataSource.logout()
    }

    suspend fun login(username: String, password: String): Result<LoggedInUser> {

        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }
}