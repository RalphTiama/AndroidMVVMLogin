package com.example.androidmvvmlogin.data

import com.example.androidmvvmlogin.data.model.LoggedInUser
import com.example.androidmvvmlogin.data.remote.LoginDataSource
import com.example.androidmvvmlogin.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(private val dataSource: LoginDataSource) : LoginRepository {

    private var user: LoggedInUser? = null

    val isLoggedIn: Boolean
        get() = user != null


    override suspend fun logout(): Result<Unit> {
        user = null
        return dataSource.logout()
    }


    override suspend fun login(username: String, password: String): Result<LoggedInUser> {
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            user = result.data
        }

        return result
    }

    override suspend fun getLoggedInUser(): LoggedInUser? {
        return dataSource.getLoggedInUser()
    }


}