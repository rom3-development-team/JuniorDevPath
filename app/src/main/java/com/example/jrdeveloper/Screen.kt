package com.example.jrdeveloper

sealed class Screen(val route: String) {
    object MainScreen : Screen(route = "main_screen")
    object LoginScreen : Screen(route = "login_screen")
    object BankingScreen : Screen(route = "banking_screen")
}