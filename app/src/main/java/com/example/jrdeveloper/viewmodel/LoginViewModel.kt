package com.example.jrdeveloper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jrdeveloper.data.LoginRepository
import com.example.jrdeveloper.data.LoginUiState
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel(): ViewModel() {

    private val loginRepository: LoginRepository = LoginRepository()
    val loginUiState: StateFlow<LoginUiState> = loginRepository.loginUiState

    fun fetchValidateCredentials(username: String, password: String){
        loginRepository.validateCredentials(username, password)
    }
}

