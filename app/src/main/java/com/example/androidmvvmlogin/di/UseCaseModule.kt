package com.example.androidmvvmlogin.di

import com.example.androidmvvmlogin.domain.repository.LoginRepository
import com.example.androidmvvmlogin.domain.usecase.LoginUseCase
import com.example.androidmvvmlogin.domain.usecase.LogoutUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideLoginUseCase(
        loginRepository: LoginRepository
    ): LoginUseCase{
        return LoginUseCase(loginRepository)
    }


    @Provides
    @Singleton
    fun provideLogoutUseCase(
        loginRepository: LoginRepository
    ): LogoutUseCase {
        return LogoutUseCase(loginRepository)
    }

}