package com.example.androidmvvmlogin.domain

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.androidmvvmlogin.data.local.LocalUserDatabase
import com.example.androidmvvmlogin.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }


    @Provides
    @Singleton
    fun provideLocalUserDatabase(@ApplicationContext context: Context): LocalUserDatabase {
        return Room.databaseBuilder(
            context,
            LocalUserDatabase::class.java, "user_db"
        ).build()
    }


    @Provides
    fun provideUserDao(database: LocalUserDatabase): UserDao {
        return database.userDao()
    }
}