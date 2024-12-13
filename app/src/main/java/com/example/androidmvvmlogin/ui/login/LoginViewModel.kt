package com.example.androidmvvmlogin.ui.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidmvvmlogin.R
import com.example.androidmvvmlogin.data.Result
import com.example.androidmvvmlogin.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state: MutableSharedFlow<LoginState> = MutableSharedFlow()
    val state: Flow<LoginState> = _state


    fun login(username: String, password: String) {
        viewModelScope.launch {

            _state.emit(LoginState.ShowProgressLoading)

            val result = loginUseCase(username, password)

            if (result is Result.Success) {
                _state.emit(
                    LoginState.LoginResult(
                        success = LoggedInUserView(
                            displayName = result.data.displayName))
                )
            } else {
                _state.emit(
                    LoginState.LoginResult(
                        error = R.string.login_failed
                    )
                )
            }
        }
    }



    fun loginDataChanged(username: String, password: String) {
        viewModelScope.launch {
            if (!isUserNameValid(username)) {
                _state.emit(
                    LoginState.LoginFormState(
                        usernameError = R.string.invalid_username
                    )
                )
            } else if (!isPasswordValid(password)) {
                _state.emit(
                    LoginState.LoginFormState(
                        passwordError = R.string.invalid_password
                    )
                )
            } else {
                _state.emit(
                    LoginState.LoginFormState(isDataValid = true)
                )
            }
        }
    }


    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        }
        else {
            username.isNotBlank() && username.length >= 3
        }
    }


    private fun isPasswordValid(password: String): Boolean {
        return password.length > 6
    }


}