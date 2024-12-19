package com.example.jrdeveloper
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() { // Change from ComponentActivity to AppCompatActivity to access supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banking)

        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, LoginFragment())
            .commit()
//
//      supportFragmentManager.beginTransaction()
//          .replace(R.id.flFragment, secondFragment)
//          .commit()
//        }
        }

    }