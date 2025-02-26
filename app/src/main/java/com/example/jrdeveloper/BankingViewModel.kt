package com.example.jrdeveloper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class BankingViewModel: ViewModel() {

    // Private mutable variable allows for only the ViewModel to modify the data
    // bank accesses the BankAccount class with the following parameters
    private var bank = BankAccount(
        accountNumber = "1234",
        accountHolder = "Madelene Mejia",
        balance = 5000.95
    )

    //
    var _bankingUiState: MutableLiveData<BankingUiState>
    val bankingUiState:


    val transactionMessage: MutableLiveData<BankingUiState> = MutableLiveData("")

    fun depositLogic(amount: Double){
        if (bank.deposit(amount)){
            balance.value = bank.getBalance()
             transactionMessage.value = "Deposit successful"
        } else {
            transactionMessage.value = "Deposit must be greater than zero"
        }
    }

    fun withdrawLogic(amount: Double){
        if (bank.withdraw(amount)) {
            balance.value = bank.getBalance()
            transactionMessage.value = "Withdraw successful"
        } else {
           transactionMessage.value =  "Insufficient funds or invalid amount. Please enter a valid amount."
        }
    }
}

data class BankingUiState(val balance: Double = 0.0, val transactionMessage: String = "")

