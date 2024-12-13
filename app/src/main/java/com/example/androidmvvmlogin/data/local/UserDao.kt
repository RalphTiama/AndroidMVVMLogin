package com.example.androidmvvmlogin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users LIMIT 1")
    suspend fun getLoggedInUser(): User?

    @Query("DELETE FROM users")
    suspend fun logOutUser()
}