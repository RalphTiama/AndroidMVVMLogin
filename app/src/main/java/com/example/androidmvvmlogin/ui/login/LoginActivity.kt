package com.example.androidmvvmlogin.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.androidmvvmlogin.MainActivity
import com.example.androidmvvmlogin.R
import com.example.androidmvvmlogin.databinding.ActivityLoginBinding
import com.example.androidmvvmlogin.ui.util.setVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = binding.username
        val password = binding.password
        val login = binding.login
        val loading = binding.loading

        binding.lottieAnimationView?.playAnimation()

        observer()

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            username.text.toString(),
                            password.text.toString()
                        )
                }
                false
            }

            login.setOnClickListener {
                loading.visibility = View.VISIBLE
                loginViewModel.login(username.text.toString(), password.text.toString())
            }
        }
    }

    private fun observer() {
        lifecycleScope.launch {
            loginViewModel.state.collect {
                handleState(it)
            }
        }

    }

    private fun handleState(state: LoginState) {

        when (state) {
            is LoginState.LoginFormState -> {
                loginFormValidateAndDisplayError(state)
            }

            is LoginState.LoginResult -> {
                processLoginResult(state)
            }

            is LoginState.ShowProgressLoading -> {
                binding.loading setVisible true
            }

            LoginState.CheckingUserSession -> {
               // binding.loading setVisible true
            }

            LoginState.LogoutResult -> {

            }
        }
    }

    private fun loginFormValidateAndDisplayError(state: LoginState.LoginFormState) {
        binding.login.isEnabled = state.isDataValid
    }

    private fun processLoginResult(state: LoginState.LoginResult) {
        binding.loading.visibility = View.GONE
        if (state.error != null) {
            showLoginFailed(state.error)
        }

        if (state.success != null) {
            updateUiWithUser(state.success)
        }

        setResult(Activity.RESULT_OK)

        finish()
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName

        Toast.makeText(applicationContext, "$welcome $displayName", Toast.LENGTH_LONG).show()

        Intent(this, MainActivity::class.java).also { startMainActivity ->
            startActivity(startMainActivity)
        }

    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

}


fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })



}