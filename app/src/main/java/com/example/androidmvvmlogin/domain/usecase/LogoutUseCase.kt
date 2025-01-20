package com.example.androidmvvmlogin.domain.usecase

import com.example.androidmvvmlogin.data.Result
import com.example.androidmvvmlogin.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {
   suspend operator fun invoke(): Result<Unit>{
        return loginRepository.logout()
    }
}