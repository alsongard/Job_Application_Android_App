package com.example.myapplication.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class JobViewModel : ViewModel() {
    var userEmail: String by mutableStateOf("")
        private set
    var userPasswd: String by mutableStateOf("")
        private set

    var userConfirmPasswd: String by mutableStateOf("")
        private set

    var warningText = ""
    var signUpLogin: Boolean by mutableStateOf(true) // by default : true set to SignUp form
        private set


    fun onChangeEmailPass(givenType: String, givenInput: String) {
        when (givenType) {
            "email" -> userEmail = givenInput
            "password" -> userPasswd = givenInput
            "confirmPasswd" -> userConfirmPasswd = givenInput
        }

    }

    fun toggleForm(boolValue: Boolean): Boolean {
        return !boolValue
    }

    fun passConfirmMatching(): Boolean {
        return userPasswd == userConfirmPasswd
    }

    fun addUser()
    {
        if (passConfirmMatching())
        {
            // do sth
            warningText = "User Added to DB!"
        }
        else
        {
            // set warning text
            warningText = "Failed registration"
        }
    }


    fun loginUser()
    {
        // compare the credentials from db to user input
    }



}