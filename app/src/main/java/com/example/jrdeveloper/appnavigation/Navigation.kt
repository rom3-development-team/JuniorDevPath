package com.example.jrdeveloper.appnavigation
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jrdeveloper.Banking_Screen
import com.example.jrdeveloper.Login_Screen
import com.example.jrdeveloper.data.LoginRepository
import com.example.jrdeveloper.viewmodel.BankingViewModel
import com.example.jrdeveloper.viewmodel.LoginViewModel

// Navigation between the Login Screen and the Banking Screen
@Composable
fun Navigation(){
    val navController = rememberNavController()

    val loginViewModel: LoginViewModel= viewModel()
    val bankingViewModel: BankingViewModel = viewModel()


    // NavHost with start destination
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route){
        composable(route = Screen.LoginScreen.route){
            Login_Screen(
                navController = navController,
                viewModel = loginViewModel
            )
        }
        composable(route = Screen.BankingScreen.route) {
            Banking_Screen(
                navController = navController,
                viewModel = bankingViewModel
            )
        }
    }
}