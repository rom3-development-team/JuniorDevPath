package com.example.jrdeveloper

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class BankingViewModel: ViewModel() {
    private var bank = BankAccount(
        accountNumber = "1234",
        accountHolder = "Madelene Mejia",
        balance = 5000.95
    )

    private val _bankingViewState: MutableLiveData<BankingViewState> = MutableLiveData(BankingViewState())
    val bankingViewState: LiveData<BankingViewState> get() = _bankingViewState

    fun depositLogic(amount: Double){
        if (bank.deposit(amount)){
            _bankingViewState.value = _bankingViewState.value?.copy(balance = bank.getBalance(), transactionMessage = "Deposit successful")

        } else {
            _bankingViewState.value = _bankingViewState.value?.copy(transactionMessage = "Deposit unsuccessful")
        }
    }

    fun withdrawLogic(amount: Double){
        if (bank.withdraw(amount)) {
            _bankingViewState.value = _bankingViewState.value?.copy(balance = bank.getBalance(), transactionMessage = "Withdraw successful")
        } else {
            _bankingViewState.value = _bankingViewState.value?.copy(transactionMessage = "Insufficient funds or invalid amount. Please enter a valid amount.")
        }
    }

    fun getBalance(){
        _bankingViewState.value = _bankingViewState.value?.copy(balance = bank.getBalance())
    }

    data class BankingViewState(val balance: Double = 0.0, val transactionMessage: String = "")

}
