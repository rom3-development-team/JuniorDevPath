package com.example.jrdeveloper

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment(R.layout.fragment_login) {
    val username = "admin"
    val password = "password"
    val secondFragment = BankingFragment()
    val args = Bundle()
    private lateinit var errorTextView: TextView


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.putString("username", username)
        args.putString("password", password)
        secondFragment.arguments = args
        errorTextView = view.findViewById(R.id.errorTextView)

        if(username== "admin" && password=="password") {
            parentFragmentManager.beginTransaction()
                .replace(R.id.flFragment, secondFragment)
                .commit()
        }
        else{
            errorTextView.text = "Invalid Credentials"
        }
    }
}

