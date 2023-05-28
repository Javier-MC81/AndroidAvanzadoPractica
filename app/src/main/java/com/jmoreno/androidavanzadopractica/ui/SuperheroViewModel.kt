package com.jmoreno.androidavanzadopractica.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jmoreno.androidavanzadopractica.remoteHeroes.Repository
import com.jmoreno.androidavanzadopractica.ui.model.Superhero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _uiListState = MutableStateFlow<SuperheroViewModel.UiListState>(SuperheroViewModel.UiListState.Idle)
    val uiListState : StateFlow<SuperheroViewModel.UiListState> = _uiListState
    //private val _heros = MutableLiveData<List<Superhero>>()
    //val heros: LiveData<List<Superhero>> get() = _heros


    fun getHeros(token: String?) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getHeros(token) // Thread.sleep(1000)
            }

            _uiListState.value = UiListState.OnListReceived(result)
        }
    }
    sealed class UiListState {
        object Idle : UiListState()
        //object Empty: UiListState()
        data class Error(val error: String) : UiListState()
        data class OnListReceived(val heroeList: List<Superhero>) : UiListState()
        data class OnHeroReceived(val personaje: Superhero): UiListState()
    }
}
