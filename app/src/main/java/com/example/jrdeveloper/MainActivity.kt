package com.example.jrdeveloper
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() { // Change from ComponentActivity to AppCompatActivity to access supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banking)

        val loginFragment = LoginFragment()

        if(savedInstanceState == null){
            navigateToFragment(loginFragment)
        }
    }

    fun navigateToFragment(fragment: Fragment, addBackToStack: Boolean = true){
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, fragment)

        if(addBackToStack){
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }
}
