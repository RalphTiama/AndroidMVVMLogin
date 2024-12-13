package com.example.androidmvvmlogin.data.remote

import com.example.androidmvvmlogin.data.Result
import com.example.androidmvvmlogin.data.local.User
import com.example.androidmvvmlogin.data.local.UserDao
import com.example.androidmvvmlogin.data.model.LoggedInUser
import kotlinx.coroutines.delay
import java.io.IOException
import javax.inject.Inject


class LoginDataSource @Inject constructor(private val userDao: UserDao) {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            //We can add API call here
            // Simulate network delay
            delay(2000)  // Simulate a 2-second network delay
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), username)

            // Save the user data into Room database
            val userEntity = User(userId = fakeUser.userId, username = username)
            userDao.insertUser(userEntity)

            return Result.Success(fakeUser)

        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    suspend fun logout() {
        userDao.logOutUser()
    }

    // TODO: I have limited time Fetch the logged-in user from Room database
    suspend fun getLoggedInUser(): LoggedInUser? {
        val userEntity = userDao.getLoggedInUser()
        return userEntity?.let {
            LoggedInUser(userId = it.userId, displayName = it.username)
        }
    }

}