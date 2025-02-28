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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Banking_Screen(viewModel: BankingViewModel, navController: NavHostController) {
    val bankingUiState by viewModel.bankingUiState.observeAsState(BankingUiState())

   var enteredAmountTextField by remember { mutableStateOf("") }
    val enteredAmount = enteredAmountTextField.toString().toDoubleOrNull() ?: 0.0

    if (bankingUiState.needInitialBalance) {
        viewModel.getBalance()
        viewModel.getAccountHolder()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
//                .padding(8.dp)
        ) {
            Text(
                text = "Hello, " + bankingUiState.accountHolder,
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("holderText"),
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )

            Text(
                text = "$" + bankingUiState.balance.toString(),
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("balanceText"),
                fontSize = 40.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )

            Spacer(Modifier.height(8.dp))

            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("transactionMessageText"),
                text = bankingUiState.transactionMessage,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Red
            )

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = enteredAmountTextField,
                onValueChange = { enteredAmountTextField = it },
                label = { Text("Enter Amount", fontFamily = FontFamily.Serif, fontSize = 30.sp) },
                placeholder = { Text("Enter an amount") }
            )

            Spacer(Modifier.height(30.dp))

            FilledTonalButton(onClick = {
                viewModel.withdrawLogic(enteredAmount)
            }) {
                Text("Withdraw", fontFamily = FontFamily.Serif, fontSize = 30.sp)
            }

            Spacer(Modifier.height(20.dp))

            FilledTonalButton(onClick = {
                viewModel.depositLogic(enteredAmount)
            }) {
                Text("Deposit", fontFamily = FontFamily.Serif, fontSize = 30.sp)
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

