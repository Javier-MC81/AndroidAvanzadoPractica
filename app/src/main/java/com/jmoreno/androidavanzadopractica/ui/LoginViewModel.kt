package com.jmoreno.androidavanzadopractica.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmoreno.androidavanzadopractica.Repository
import com.jmoreno.androidavanzadopractica.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: Repository): ViewModel() {

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
