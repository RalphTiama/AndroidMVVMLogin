package com.example.androidmvvmlogin.domain.usecase


import com.example.androidmvvmlogin.data.model.LoggedInUser
import javax.inject.Inject
import com.example.androidmvvmlogin.data.Result
import com.example.androidmvvmlogin.domain.repository.LoginRepository

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(username: String, password: String): Result<LoggedInUser> {
        return loginRepository.login(username, password)
    }


}