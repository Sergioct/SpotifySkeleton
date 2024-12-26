package com.sergiocrespotoubes.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergiocrespotoubes.common.SpotifyLog
import com.sergiocrespotoubes.domain.model.ArtistModel
import com.sergiocrespotoubes.domain.usecase.artist.GetArtistsFromDbUseCase
import com.sergiocrespotoubes.domain.usecase.search.GetSearchByArtistUseCase
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
class SearchViewModel @Inject constructor(
    private val getSearchByArtistUseCase: GetSearchByArtistUseCase,
    private val getArtistsFromDbUseCase: GetArtistsFromDbUseCase,
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
        }
    }

    fun onInputTextUpdate(inputText: String) = viewModelScope.launch {
        _state.emit(_state.value.copy(inputText = inputText))
        getSearchByArtist(artistName = inputText)
    }

    private suspend fun getArtistsFromDb() {
        SpotifyLog.i("getSearchByArtist()")
        getArtistsFromDbUseCase.execute().collect { searchResult ->
            searchResult.onSuccess { artists ->
                _state.value = _state.value.copy(
                    artists = artists
                )
            }
        }
    }

    private suspend fun getSearchByArtist(artistName: String) {
        showLoading()
        SpotifyLog.i("onInputTextUpdate($artistName)")
        getSearchByArtistUseCase.execute(artistName).collect { searchResult ->
            searchResult.onSuccess { artists ->
                _state.value = _state.value.copy(
                    artists = artists,
                    loading = false
                )
            }.onFailure {
                _state.value = _state.value.copy(
                    loading = false
                )
            }
        }
    }

    private fun showLoading(){
        _state.value = _state.value.copy(
            loading = false
        )
    }

    sealed class Event {
        data object NavigateToArtistSearch : Event()
        data object ShowError : Event()
    }

    data class State(
        val inputText: String = "",
        val artists: List<ArtistModel> = emptyList(),
        val loading: Boolean = false,
    )
}
