package com.example.jrdeveloper

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController

class LoginViewModel: ViewModel() {

    // Private mutable variable allows for only the ViewModel to modify the data
    private var _loginUiState: MutableLiveData<LoginUiState> = MutableLiveData(LoginUiState())
    val loginUiState: LiveData<LoginUiState> get() = _loginUiState

    fun validateCredentials(username: String, password: String): Boolean {
        if (username == "admin" && password == "password") {
            _loginUiState.value = _loginUiState.value?.copy(username = "admin", password = "password")
            return true
        } else {
            _loginUiState.value = _loginUiState.value?.copy(error = "Invalid credentials")
            return false
        }
    }
}

// Holds the data variables (username and password) for the LoginUiState class
data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val error: String = ""
)