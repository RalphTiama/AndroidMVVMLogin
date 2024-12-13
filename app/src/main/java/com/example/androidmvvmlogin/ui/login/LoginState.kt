package com.example.androidmvvmlogin.ui.login

sealed class LoginState {

    data class LoginResult(
        val success: LoggedInUserView? = null,
        val error: Int? = null
    ) : LoginState()

    data class LoginFormState(
        val usernameError: Int? = null,
        val passwordError: Int? = null,
        val isDataValid: Boolean = false
    ) : LoginState()

    data object ShowProgressLoading : LoginState()


}