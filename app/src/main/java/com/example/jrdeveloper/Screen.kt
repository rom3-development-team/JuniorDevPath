package com.example.jrdeveloper

sealed class Screen(val route: String) {
    object LoginScreen : Screen(route = "login_screen")
    object BankingScreen : Screen(route = "banking_screen")
}