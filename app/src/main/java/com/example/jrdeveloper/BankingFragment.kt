package com.example.jrdeveloper

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass.
 */
class BankingFragment : Fragment(R.layout.fragment_banking) {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bankingViewModel = ViewModelProvider(this)[BankingViewModel::class.java]
        val username = arguments?.getString("username")

        // UI element references
        val amountEditText: EditText = view.findViewById(R.id.amountEditText)
        val depositButton: Button = view.findViewById(R.id.depositButton)
        val withdrawButton: Button = view.findViewById(R.id.withdrawButton)
        val accountHolderTextView: TextView = view.findViewById(R.id.holderTextView)
        val accountBalanceTextView: TextView = view.findViewById(R.id.balanceTextView)
        val transactionMessageTextView: TextView = view.findViewById(R.id.transactionMessageTextView)

        // Sets the account holder's username
        accountHolderTextView.text = "Account Holder: $username"

        // Sets the account balance value to the text view
        // val initialBalance = bankingViewModel.balance.value ?: 0.0
        // accountBalanceTextView.text = "Balance: $${"%.2f".format(initialBalance)}"
        bankingViewModel.getBalance()

        // Observe balance changes from the ViewModel and update the UI
        bankingViewModel.bankingViewState.observe(viewLifecycleOwner) { viewState ->
            accountBalanceTextView.text = "Balance: $${"%.2f".format(viewState.balance)}"
            transactionMessageTextView.text = viewState.transactionMessage
        }


        // Deposit Button click listener
        depositButton.setOnClickListener {
            val amount = amountEditText.text.toString().toDoubleOrNull() ?: 0.0
            bankingViewModel.depositLogic(amount)
        }

        // Withdraw Button click listener
        withdrawButton.setOnClickListener {
            val amount = amountEditText.text.toString().toDoubleOrNull() ?: 0.0
            bankingViewModel.withdrawLogic(amount)
        }
    }
}