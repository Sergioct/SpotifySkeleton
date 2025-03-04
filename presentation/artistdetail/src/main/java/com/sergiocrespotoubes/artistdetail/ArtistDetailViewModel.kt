package com.sergiocrespotoubes.artistdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.usecase.artist.GetArtistByArtistId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistDetailViewModel
    @Inject
    constructor(
        val getArtistByArtistId: GetArtistByArtistId,
    ) : ViewModel() {
        private val _state: MutableStateFlow<State> = MutableStateFlow(State())
        val state: StateFlow<State>
            get() = _state.asStateFlow()

        private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
        val event: SharedFlow<Event>
            get() = _event.asSharedFlow()

        fun getArtist(artistId: String) =
            viewModelScope.launch {
                getArtistByArtistId.execute(artistId).collect { result ->
                    result.onSuccess { artist ->
                        _state.value =
                            state.value.copy(
                                artist = artist,
                            )
                    }.onFailure {
                        _event.emit(Event.ShowError)
                    }
                }
            }

        sealed class Event {
            data object ShowError : Event()
        }

        data class State(
            val artist: ArtistModel? = null,
        )
    }
