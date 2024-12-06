package com.example.jrdeveloper

// import androidx.lifecycle.LifecycleEventObserver
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.DefaultLifecycleObserver

open class BankLifecycleObserver: DefaultLifecycleObserver {

    open val lifecycle_tag: String = "Lifecycle"
    open val mainActivity_tag: String = "MainActivity"

    override fun onResume(owner: LifecycleOwner){
        super.onCreate(owner)
        Log.d(mainActivity_tag, "OnResume called")
    }

    override fun onPause(owner: LifecycleOwner){
        super.onPause(owner)
        Log.d(mainActivity_tag, "OnPause called")
    }


}
