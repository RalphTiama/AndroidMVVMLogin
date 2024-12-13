package com.example.androidmvvmlogin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val userId: String,
    val username: String
)