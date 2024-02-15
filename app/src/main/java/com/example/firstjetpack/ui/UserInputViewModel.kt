package com.example.firstjetpack.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.firstjetpack.data.UserDataUIEvents
import com.example.firstjetpack.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    companion object{

        const val TAG = "UserInputViewModel"

    }

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUIEvents){
        when(event){
            is UserDataUIEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "onEvent:UserNameEntered")
                Log.i(TAG, "${uiState.value}")
            }
            is UserDataUIEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSeleted = event.animalValue
                )
                Log.d(TAG, "onEvent:AnimalSelected")
                Log.i(TAG, "${uiState.value}")
            }
        }
    }

    fun isValidState(): Boolean{
        return (uiState.value.nameEntered.isNotEmpty() && uiState.value.animalSeleted.isNotEmpty())
    }
}
