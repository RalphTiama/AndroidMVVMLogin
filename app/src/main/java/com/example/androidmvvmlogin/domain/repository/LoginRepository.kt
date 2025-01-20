package com.example.androidmvvmlogin.domain.repository

import com.example.androidmvvmlogin.data.Result
import com.example.androidmvvmlogin.data.model.LoggedInUser
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun login(username: String, password: String): Result<LoggedInUser>
    suspend fun getLoggedInUser(): LoggedInUser?
    suspend fun logout(): Result<Unit>
}