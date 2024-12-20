package com.example.jrdeveloper
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() { // Change from ComponentActivity to AppCompatActivity to access supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banking)

        val loginFragment = LoginFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, loginFragment)
            .commit()

//
//      supportFragmentManager.beginTransaction()
//          .replace(R.id.flFragment, secondFragment)
//          .commit()
//        }
        }

    }