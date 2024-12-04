package com.example.jrdeveloper

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.annotation.SuppressLint
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {

    // private lateinit var bank: BankAccount
    private val bankObserver = BankLifecycleObserver()
    private lateinit var lifecycleState: TextView
    private var initialBalance: Double = 5000.95

    val bank = BankAccount(
        accountNumber = "1234",
        accountHolder = "John Smith",
        balance = initialBalance
    )

    @SuppressLint("SetTextI18n")
    // onCreate() is the method that is called when the activity is first created.
    // Where you initialize your activity and UI components.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banking)
        lifecycleState = findViewById(R.id.LifecycleState)
        Log.d(bankObserver.lifecycle_tag, "OnCreate called")
        lifecycleState.text = "Activity is being created (onCreate)"


        initialBalance = savedInstanceState?.getDouble("balance") ?: 5000.95

//        val bank = BankAccount(
//            accountNumber = "1234",
//            accountHolder = "John Smith",
//            balance = initialBalance
//        )

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
                Toast.makeText(
                    this,
                    "Invalid deposit amount. Please enter a valid amount.",
                    Toast.LENGTH_SHORT
                ).show()
            }
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



    // The onSaveInstanceState() methods saves important UI state data before an activity may be destroyed or recreated.
    // Saving a double value representing the bank balance to the Bundle object so it can be restored later.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("balance", bank.getBalance())
    }

    @SuppressLint("SetTextI18n")
    override fun onStart(){
        super.onStart()
        Log.d(bankObserver.lifecycle_tag, "OnStart called")
        lifecycleState.text = "Activity is visible, but not interactive yet (onStart)"
    }

    @SuppressLint("SetTextI18n")
    override fun onResume(){
        super.onResume()
        Log.d(bankObserver.lifecycle_tag, "OnResume called")
        lifecycle.addObserver(bankObserver)
        lifecycleState.text = "Activity is in the foreground and ready to interact with the user (onResume)"
    }

    @SuppressLint("SetTextI18n")
    override fun onPause(){
        super.onPause()
        Log.d(bankObserver.lifecycle_tag, "onStart called")
        lifecycle.addObserver(bankObserver)
        lifecycleState.text = "Activity is partially visible but no longer in the foreground (onPause)"
    }

    @SuppressLint("SetTextI18n")
    override fun onStop(){
        super.onStop()
        Log.d(bankObserver.lifecycle_tag, "onStop called")
        lifecycleState.text = "Activity is no longer visible to the user (onStop)"
    }

    @SuppressLint("SetTextI18n")
    override fun onDestroy() {
        super.onDestroy()
        Log.d(bankObserver.lifecycle_tag, "oDestroy called")
        lifecycleState.text = "Activity is cleaning up, about to be destroyed (onDestory)"
    }

    @SuppressLint("SetTextI18n")
    override fun onRestart() {
        super.onRestart()
        Log.d(bankObserver.lifecycle_tag, "onRestart called")
        lifecycleState.text = "Activity is being restarted after being stopped (onRestart)"
    }

}
