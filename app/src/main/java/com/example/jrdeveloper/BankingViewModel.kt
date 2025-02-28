package com.example.jrdeveloper

import androidx.lifecycle.LiveData
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

    // Private mutable variable allows for only the ViewModel to modify the _bankingUiState data
    // Stores current UI state
    private var _bankingUiState: MutableLiveData<BankingUiState> = MutableLiveData(BankingUiState())

    // Allows the private _bankingUiState data to be accessed as read-only
    // By storing the data in a public immutable field (val)
    val bankingUiState: LiveData<BankingUiState> get() = _bankingUiState

    // Deposit Logic data
    fun depositLogic(amount: Double){
        // If we call the deposit method with a value passed in the parameter for the amount...
        if (bank.deposit(amount)){
            // The _bankingUiState (Mutable Live Date) value is set to the updated balance and transaction message
            _bankingUiState.value = _bankingUiState.value?.copy(balance = bank.getBalance(), transactionMessage = "Deposit Successful!")
        } else {
            // The balance remains unchanged and the transaction message is updated
            _bankingUiState.value = _bankingUiState.value?.copy(transactionMessage = "Deposit must be greater than 0")
        }
    }

    // Withdraw Logic data
    fun withdrawLogic(amount: Double){
        // If we call the withdraw method with a value passed in the parameter for the amount...
        if (bank.withdraw(amount)) {
            // The _bankingUiState (Mutable Live Data) value is set to the updated balance and transaction message
            _bankingUiState.value = _bankingUiState.value?.copy(balance = bank.getBalance(), transactionMessage = "Withdraw Successful!")
        } else {
            // The balance remains unchanged and the transaction message is updated
           _bankingUiState.value = _bankingUiState.value?.copy(transactionMessage = "Insufficient funds or invalid amount. Please enter a valid amount.")
        }
    }

    // Gets the balance of the _bankingUiState
    fun getBalance(){
//        _bankingUiState.value = _bankingUiState.value?.copy(balance = bank.getBalance())

        _bankingUiState.value = _bankingUiState.value?.copy(balance = bank.getBalance(), needInitialBalance = false)
    }

    fun getAccountHolder(){
        _bankingUiState.value = _bankingUiState.value?.copy(accountHolder = bank.getAccountHolder())
    }

}

// Holds the data variables (balance and transaction message) for the BankingUiState class
data class BankingUiState(
    val balance: Double = 0.0,
    val transactionMessage: String = "",
    val accountHolder: String = "",
    val needInitialBalance: Boolean = true
)

