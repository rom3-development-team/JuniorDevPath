package com.example.jrdeveloper.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginRepository {

//    // Private mutable variable allows for only the ViewModel to modify the data
//    private var _loginUiState: MutableLiveData<LoginUiState> = MutableLiveData(LoginUiState())
//    val loginUiState: LiveData<LoginUiState> get() = _loginUiState

    // Private mutable variable allows for only the ViewModel to modify the data
    private var _loginUiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState())
    val loginUiState: StateFlow<LoginUiState> get() = _loginUiState

    private val mockUsername = "admin"
    private val mockPassword = "password"

    fun validateCredentials(username: String, password: String) {
        if (username == mockUsername && password == mockPassword) {
            _loginUiState.value = _loginUiState.value.copy(isValid = true)
        } else {
            _loginUiState.value = _loginUiState.value.copy(isValid = false, error = "Invalid username or password")
        }
    }
}


// Holds the data variables (username and password) for the LoginUiState class
data class LoginUiState(
    val username: String = "",
    val password: String = "",
    val error: String = "",
    val isValid: Boolean = false
)