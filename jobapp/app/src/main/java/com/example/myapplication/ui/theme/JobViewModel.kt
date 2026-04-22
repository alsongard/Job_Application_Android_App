package com.example.myapplication.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.network.JobApi
import kotlinx.coroutines.launch
import java.io.IOException


// . A sealed interface makes it easy to manage state by limiting the possible values
sealed interface  JobUiState {
    data class Success(val jobs: String): JobUiState
    object Error : JobUiState
    object Loading : JobUiState
}
class JobViewModel : ViewModel() {

    var jobUiState: JobUiState by mutableStateOf(JobUiState.Loading)

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

    // A viewModelScope is the built-in coroutine scope defined for each ViewModel in your app. Any coroutine launched in this scope is automatically canceled if the ViewModel is cleared.

    private fun getJobInfo(){
        viewModelScope.launch {
            try {

                var listResult = JobApi.retrofitService.getJobInfo()

                // reassigning jobUiState to value of type String: Result of JobUiState.Success: this is a data class that takes a parameter of type String
                jobUiState = JobUiState.Success(listResult)
            }
            catch (e: IOException)
            {
                jobUiState = JobUiState.Error
            }
        }
    }


}