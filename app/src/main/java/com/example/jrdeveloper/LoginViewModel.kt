package com.example.jrdeveloper

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class LoginViewModel: ViewModel() {

    // Private mutable variable allows for only the ViewModel to modify the data
    private var _loginUiState: MutableLiveData<LoginUiState> = MutableLiveData(LoginUiState())
    val loginUiState: LiveData<LoginUiState> get() = _loginUiState

    fun validateCredentials(username: String, password: String) {
        if (username == "admin" && password == "password") {
            _loginUiState.value = _loginUiState.value?.copy(isValid = true, error = null)
        } else {
            _loginUiState.value =
                _loginUiState.value?.copy(isValid = false, error = "Invalid credentials")
        }
    }
}


// Holds the data variables (username and password) for the LoginUiState class
data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val error: String? = null,
    val isValid: Boolean = false
)