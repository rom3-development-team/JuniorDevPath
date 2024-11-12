package com.example.jrdeveloper

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.annotation.SuppressLint
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : ComponentActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banking)

        val bank = BankAccount(
            accountNumber = "1234",
            accountHolder = "John Smith",
            balance = 5000.95
        )

        // UI element references
        val amountEditText: EditText = findViewById(R.id.amountEditText)
        val depositButton: Button = findViewById(R.id.depositButton)
        val withdrawButton: Button = findViewById(R.id.withdrawButton)

        // Sets the account holder value to the text view
        val accountHolder = bank.getAccountHolder()
        val accountHolderTextView: TextView = findViewById(R.id.holderTextView)
        accountHolderTextView.text = "Account Holder: $accountHolder"

        // Sets the account balance value to the text view
        val accountBalance = bank.getBalance()
        val accountBalanceTextView: TextView = findViewById(R.id.balanceTextView)
        accountBalanceTextView.text = "Balance: $${accountBalance}"

        // Deposit Button click listener
        depositButton.setOnClickListener {
            val amount = amountEditText.text.toString().toDouble()
            if (bank.deposit(amount)) {
                accountBalanceTextView.text = "Balance: $${accountBalance}"
                Toast.makeText(this, "Deposit successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid deposit amount. Please enter a valid amount.", Toast.LENGTH_SHORT).show()
            }

            // Withdraw Button click listener
            withdrawButton.setOnClickListener {
                val amount = amountEditText.text.toString().toDouble()
                if (bank.withdraw(amount)) {
                    accountBalanceTextView.text = "Balance: $${accountBalance}"
                    Toast.makeText(this, "Withdraw successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Insufficient funds or invalid amount. Please enter a valid amount.", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}


