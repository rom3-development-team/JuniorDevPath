package com.example.jrdeveloper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Banking_Screen(viewModel: BankingViewModel, navController: NavHostController) {
    val bankingUiState by viewModel.bankingUiState.observeAsState(BankingUiState())

   var enteredAmountTextField by remember { mutableStateOf(TextFieldValue("")) }
    val enteredAmount = enteredAmountTextField.toString().toDoubleOrNull() ?: 0.0
//
//    if (bankingUiState.needInitialBalance) {
//        viewModel.getBalance()
//    }

    // val login_background = painterResource(id = R.drawable.galaxy_background )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
//        Image(
//            painter = login_background,
//            contentDescription = null,
//            Modifier.fillMaxSize(),
//            contentScale = ContentScale.Crop,
////            alpha = 0.8F
//        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Text(
                text = bankingUiState.accountHolder,
                modifier = Modifier
                    .padding(28.dp)
                    .testTag("holderText"),
                fontSize = 30.sp,
                color = Color.Black
            )

            Text(
                text = bankingUiState.balance.toString(),
                modifier = Modifier
                    .padding(28.dp)
                    .testTag("balanceText"),
                fontSize = 34.sp,
                color = Color.Black
            )

            Text(
                modifier = Modifier
                    .padding(28.dp)
                    .testTag("transactionMessageText"),
                text = bankingUiState.transactionMessage,
                fontSize = 24.sp,
                color = Color.Black
            )

            OutlinedTextField(
                value = enteredAmountTextField,
                onValueChange = { enteredAmountTextField = it },
                label = { Text("Enter Amount") },
                placeholder = { Text("Enter the amount you would like to withdraw or deposit") }
            )

            Spacer(Modifier.height(16.dp))

            FilledTonalButton(onClick = {
                viewModel.withdrawLogic(enteredAmount)
            }) {
                Text("Withdraw")
            }

            Spacer(Modifier.height(16.dp))

            FilledTonalButton(onClick = {
                viewModel.depositLogic(enteredAmount)
            }) {
                Text("Deposit")
            }
        }
    }

}
//
//@Preview
//@Composable
//fun Fragment_Banking_Preview(){
//    Fragment_Banking(holderText = "Holder", balanceText  = "Balance", transactionMessageText = "transactionMessage")
//}

