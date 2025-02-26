package com.example.jrdeveloper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class BankingViewModel: ViewModel() {
//    private var bank = BankAccount(
//        accountNumber = "1234",
//        accountHolder = "Madelene Mejia",
//        balance = 5000.95
//    )

    val balance: MutableLiveData<Double> = MutableLiveData(bankUiState.bank.getBalance())
    val transactionMessage: MutableLiveData<String> = MutableLiveData("")

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

data class bankUiState(
    private var bank: BankAccount = BankAccount(
        accountNumber = "1234",
        accountHolder = "Madelene Mejia",
        balance = 5000.95
    )

)
