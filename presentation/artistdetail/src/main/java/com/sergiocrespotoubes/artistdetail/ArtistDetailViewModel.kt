package com.sergiocrespotoubes.artistdetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ArtistDetailViewModel
    @Inject
    constructor() : ViewModel() {
        private val _state: MutableStateFlow<State> = MutableStateFlow(State())
        val state: StateFlow<State>
            get() = _state.asStateFlow()

        private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
        val event: SharedFlow<Event>
            get() = _event.asSharedFlow()

        init {
        }

        sealed class Event {
            data object ShowError : Event()
        }

        data class State(
            val title: String = "",
        )
    }
