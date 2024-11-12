package com.example.jrdeveloper

class BankAccount (
    private val accountNumber: String,
    private val accountHolder: String,
    private var balance: Double
) {

    fun getAccountNumber(): String {
        return accountNumber
    }

    fun getAccountHolder(): String {
        return accountHolder
    }

    fun getBalance(): Double {
        return balance
    }

    // Add funds to the account
    fun deposit(amount: Double): Boolean {
        if (amount > 0) {
            balance += amount
            return true
        } else {
            return false

        }
    }

    // Subtracts funds if there are sufficient funds
    fun withdraw(amount: Double): Boolean {
        if (amount > 0 && amount <= getBalance()) {
            balance -= amount
            return true
        } else {
            return false
        }
    }
}