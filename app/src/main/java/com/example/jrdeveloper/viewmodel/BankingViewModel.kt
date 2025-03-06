package com.example.jrdeveloper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jrdeveloper.data.BankingRepository
import com.example.jrdeveloper.data.BankingUiState
import com.example.jrdeveloper.data.LoginUiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BankingViewModel(): ViewModel() {

    private val bankingRepository: BankingRepository = BankingRepository()
     val bankingUiState: StateFlow<BankingUiState> = bankingRepository.bankingUiState

    fun fetchBalance(){
        bankingRepository.getBalance()
    }

    fun fetchWithdraw(amount: Double){
        bankingRepository.withdrawLogic(amount)
    }

    fun fetchDeposit(amount: Double){
        bankingRepository.depositLogic(amount)
    }

    fun fetchAccountHolder(){
        bankingRepository.getAccountHolder()
    }

}

