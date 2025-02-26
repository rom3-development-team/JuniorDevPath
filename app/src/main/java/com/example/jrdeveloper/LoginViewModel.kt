package com.example.jrdeveloper

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController

class LoginViewModel: ViewModel() {

    val username: MutableLiveData<String> = MutableLiveData("")



    val password: MutableLiveData<String> = MutableLiveData("")



    var isValidCredentials: Boolean = false

    fun validateCredentials(username: String, password: String, navController: NavController) {
        if(username == "admin" && password == "password") {
            isValidCredentials = true
        } else {
            isValidCredentials = false
            // error message 
        }
    }
}