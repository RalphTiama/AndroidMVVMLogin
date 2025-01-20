package com.example.androidmvvmlogin.domain.repository

import com.example.androidmvvmlogin.data.Result
import com.example.androidmvvmlogin.data.model.LoggedInUser

interface LoginRepository {
    suspend fun login(username: String, password: String): Result<LoggedInUser>
}