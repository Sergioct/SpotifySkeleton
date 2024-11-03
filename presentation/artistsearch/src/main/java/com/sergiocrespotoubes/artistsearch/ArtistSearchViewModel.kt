package com.sergiocrespotoubes.artistsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistSearchViewModel
    @Inject
    constructor() : ViewModel() {
        // private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
        // val state: StateFlow<State>
        //    get() = _state.asStateFlow()

        private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
        val event: SharedFlow<Event>
            get() = _event.asSharedFlow()

        init {
            initSplashCountDown()
        }

        private fun initSplashCountDown() =
            viewModelScope.launch {
                delay(2000)
                _event.emit(Event.NavigateToArtistSearch)
            }

        sealed class Event {
            data object NavigateToArtistSearch : Event()
        }
    }
