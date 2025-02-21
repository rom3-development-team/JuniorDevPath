package com.example.jrdeveloper

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun Login_Screen(navController: navController, modifier: Modifier = Modifier) {
    val login_icon = painterResource(R.drawable.icon_account_circle)
    val login_background = painterResource(R.drawable.login_background)

    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = login_background,
            contentDescription = null
        )


        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Image(
                painter = login_icon,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = 0.5F
            )

            FilledTonalButton(onClick = {}) {
                Text("Login")
            }
            OutlinedTextField(
                value = username,
                label = { Text(text = "Enter Username") },
                placeholder = { Text(text="Enter your username")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                onValueChange = { username = it }
            )

            OutlinedTextField(
                value = password,
                label = { Text(text = "Enter Password")},
                placeholder = {Text(text="Enter your password")},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                onValueChange = { password = it }
            )

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Fragment_Login_Preview() {
//        Fragment_Login()
//    }
