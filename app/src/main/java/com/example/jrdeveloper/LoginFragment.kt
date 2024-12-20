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
    private lateinit var errorTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    val secondFragment = BankingFragment()


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        errorTextView = view.findViewById(R.id.errorTextView)
        usernameEditText = view.findViewById(R.id.username_input)
        passwordEditText = view.findViewById(R.id.password_input)
        loginButton = view.findViewById(R.id.loginButton)


        loginButton.setOnClickListener{
            val password = passwordEditText.text.toString()
            val username = usernameEditText.text.toString()

            if (username == "admin" && password == "password") {
                val args = Bundle()
                args.putString("username", username)
                secondFragment.arguments = args
                parentFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, secondFragment)
                    .commit()
            } else {
                errorTextView.text = "Invalid Credentials"
                errorTextView.visibility = view.visibility
            }

        }
//        loginButton.setOnClickListener{
//            val username = usernameEditText.text.toString()
//            val password = passwordEditText.text.toString()
//
//            if (username == "admin" && password == "password") {
//                parentFragmentManager.beginTransaction()
//                    .replace(R.id.flFragment, secondFragment)
//                    .commit()
//            } else {
//                errorTextView.text = "Invalid Credentials"
//                errorTextView.visibility = view.visibility
//            }
//
//        }

    }

    }

