package com.sergiocrespotoubes.trackdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.model.TrackModel
import com.sergiocrespotoubes.domain.usecase.artist.GetArtistsFromDbUseCase
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByArtistUseCase
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByTrackUseCase
import com.sergiocrespotoubes.domain.usecase.tracks.GetTracksFromDbUseCase
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
class TrackDetailViewModel @Inject constructor(
    private val getSearchByArtistUseCase: GetSearchByArtistUseCase,
    private val getSearchByTrackUseCase: GetSearchByTrackUseCase,
    private val getArtistsFromDbUseCase: GetArtistsFromDbUseCase,
    private val getTracksFromDbUseCase: GetTracksFromDbUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State>
       get() = _state.asStateFlow()

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    val event: SharedFlow<Event>
        get() = _event.asSharedFlow()

    init {
        viewModelScope.launch {
            getArtistsFromDb()
            //getTracksFromDb()
        }
    }

    fun onInputTextUpdate(inputText: String) = viewModelScope.launch {
        _state.emit(_state.value.copy(inputText = inputText))
        getSearchByArtist(artistName = inputText)
        getSearchByTrack(trackName = inputText)
    }

    private suspend fun getArtistsFromDb() {
        getArtistsFromDbUseCase.execute().collect { searchResult ->
            searchResult.onSuccess { artists ->
                _state.value = _state.value.copy(
                    artists = artists
                )
            }
        }
    }

    private suspend fun getTracksFromDb() {
        getTracksFromDbUseCase.execute().collect { searchResult ->
            searchResult.onSuccess { tracks ->
                _state.value = _state.value.copy(
                    tracks = tracks
                )
            }
        }
    }

    private suspend fun getSearchByArtist(artistName: String) {
        _state.value = _state.value.copy(
            artistLoading = true
        )
        getSearchByArtistUseCase.execute(artistName).collect { searchResult ->
            searchResult.onSuccess { artists ->
                _state.value = _state.value.copy(
                    artists = artists,
                    artistLoading = false
                )
            }.onFailure {
                _state.value = _state.value.copy(
                    artistLoading = false
                )
            }
        }
    }

    private suspend fun getSearchByTrack(trackName: String) {
        _state.value = _state.value.copy(
            trackLoading = true
        )
        getSearchByTrackUseCase.execute(trackName).collect { searchResult ->
            searchResult.onSuccess { tracks ->
                _state.value = _state.value.copy(
                    tracks = tracks,
                    trackLoading = false
                )
            }.onFailure {
                _state.value = _state.value.copy(
                    trackLoading = false
                )
            }
        }
    }

    sealed class Event {
        data object NavigateToArtistSearch : Event()
        data object ShowError : Event()
    }

    data class State(
        val inputText: String = "",
        val artists: List<ArtistModel> = emptyList(),
        val tracks: List<TrackModel> = emptyList(),
        val artistLoading: Boolean = false,
        val trackLoading: Boolean = false,
    )
}
