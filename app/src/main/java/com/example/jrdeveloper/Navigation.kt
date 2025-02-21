package com.example.jrdeveloper
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDesination = Screen.MainScreen.route){
//        composable(route = Screen.MainScreen.route){
//            Activity_Banking(navController = navController)
//        }
        composable(route = Screen.LoginScreen.route){
           // Login_Screen(navController = navController)
        }
        composable(route = Screen.BankingScreen.route) {
           // Banking_Screen(navController = navController)
        }
    }
}