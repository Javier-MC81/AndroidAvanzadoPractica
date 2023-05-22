package com.jmoreno.androidavanzadopractica

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel: ViewModel() {
    private val repository = Repository()

    private val _token = MutableStateFlow<UiState>(UiState.Idle)
    val token: StateFlow<UiState> = _token


    fun getLogin(credential: String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getToken(credential)

            }

            _token.value = UiState.OnTokenReceived(result)
        }
    }

    sealed class UiState {
        object Idle : UiState()
        data class Error(val error: String) : UiState()
        data class OnTokenReceived(val text: String) : UiState()

    }
}