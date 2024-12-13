package com.example.androidmvvmlogin.domain

import com.example.androidmvvmlogin.data.LoginRepository
import com.example.androidmvvmlogin.data.model.LoggedInUser
import javax.inject.Inject
import com.example.androidmvvmlogin.data.Result

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(username: String, password: String): Result<LoggedInUser> {
        return loginRepository.login(username, password)
    }





}