package com.example.jrdeveloper

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jrdeveloper.appnavigation.Screen
import com.example.jrdeveloper.data.LoginUiState
import com.example.jrdeveloper.viewmodel.LoginViewModel


@Composable
fun Login_Screen(viewModel: LoginViewModel, navController: NavHostController) {

    val loginUiState by viewModel.loginUiState.collectAsState()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val login_background = painterResource(id = R.drawable.galaxy_background)
//
//    if (loginUiState.isValid) {
//        LaunchedEffect(Unit) {
//            navController.navigate(Screen.BankingScreen.route)
//        }
//    }

    LaunchedEffect(loginUiState.isValid) {
        if (loginUiState.isValid){
            navController.navigate(Screen.BankingScreen.route)
        }
    }

    Box {


        Image(
            painter = login_background,
            contentDescription = null,
            Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = "Sign In",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
               fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .padding(16.dp)
            )

            Spacer(Modifier.height(20.dp))


            OutlinedTextField(
                value = username,
               // label = { Text(text = "Username", color = Color.Black) } ,
                placeholder = { Text(text = "Username", color = Color.White, fontFamily = FontFamily.Serif)},
                textStyle = TextStyle(color = Color.White),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = { username = it },
            )

            Spacer(Modifier.height(16.dp))


            OutlinedTextField(
                value = password,
               // label = { Text(text = "Enter Password", color = Color.White) },
                placeholder = { Text(text = "Password", color = Color.White, fontFamily = FontFamily.Serif)},
                visualTransformation = PasswordVisualTransformation(),
                textStyle = TextStyle(color = Color.White),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password = it }
            )

           Spacer(Modifier.height(20.dp))

            FilledTonalButton(onClick = {
                viewModel.fetchValidateCredentials(username, password)
            }) {
                Text(text = "Login",
                    style = TextStyle(
                        fontSize = 24.sp,
                        shadow = Shadow(
                            color = Color.Blue,
                            blurRadius = 5f
                        )

                    )
                )
            }
            Text(
                text = loginUiState.error.toString(),
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .padding(16.dp)
            )

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Fragment_Login_Preview() {
//        Fragment_Login()
//    }
