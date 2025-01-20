package com.example.androidmvvmlogin.di

import com.example.androidmvvmlogin.data.LoginRepositoryImpl
import com.example.androidmvvmlogin.data.remote.LoginDataSource
import com.example.androidmvvmlogin.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

object RepositoryModule {
    @Provides
    @Singleton
    fun provideLoginRepository(
        loginDataSource: LoginDataSource
    ) : LoginRepository{
        return LoginRepositoryImpl(loginDataSource)
    }


}