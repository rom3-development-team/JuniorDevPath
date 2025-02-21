package com.example.jrdeveloper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Banking_Screen(holderText: String, balanceText: String, transactionMessageText: String, modifier: Modifier = Modifier) {

    var enterAmountTextField by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        Text(
            text = holderText,
            modifier = Modifier
                .padding(28.dp)
                .testTag("holderText"),
            fontSize = 30.sp,
            color = Color.Black
        )

        Text(
            text = balanceText,
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
            text = transactionMessageText,
            fontSize = 24.sp,
            color = Color.Black
        )
        FilledTonalButton(onClick = {}) {
            Text("Withdraw")
        }

        FilledTonalButton(onClick = {}) {
            Text("Deposit")
        }
    }
    // Amount TextField
    OutlinedTextField(
        value = enterAmountTextField,
        onValueChange = { enterAmountTextField = it },
        label = { Text("Enter Amount" )},
        placeholder = { Text("Enter the amount you would like to withdraw or deposit")}
    )

}
//
//@Preview
//@Composable
//fun Fragment_Banking_Preview(){
//    Fragment_Banking(holderText = "Holder", balanceText  = "Balance", transactionMessageText = "transactionMessage")
//}

