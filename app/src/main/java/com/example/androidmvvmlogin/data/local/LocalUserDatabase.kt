package com.example.androidmvvmlogin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class LocalUserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}