package com.example.moviebuffs.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebuffs.ui.network.MovieBuffsApi
import com.example.moviebuffs.ui.network.MovieBuffsPhoto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MovieBuffsUiState {
    data class Success(val photos: List<MovieBuffsPhoto>) : MovieBuffsUiState
    object Error : MovieBuffsUiState
    object Loading : MovieBuffsUiState
}

data class UiState(
    val currentMovie: MovieBuffsPhoto?,
    val isShowingListPage: Boolean = true
)
class MovieBuffsViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var movieBuffsUiState: MovieBuffsUiState by mutableStateOf(MovieBuffsUiState.Loading)
        private set

    private val _uiState = MutableStateFlow(
        UiState(
            currentMovie = null,
            isShowingListPage = true
        )
    )
    val uiState: StateFlow<UiState> = _uiState

    init {
        getMoviePhotos()
    }

    fun updateCurrentMovie(selectedMovie: MovieBuffsPhoto) {
        _uiState.update {
            it.copy(currentMovie = selectedMovie)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }

    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }

    fun getMoviePhotos() {
        viewModelScope.launch {
            movieBuffsUiState = try {
                MovieBuffsUiState.Success(MovieBuffsApi.retrofitService.getPhotos())
            } catch (e: IOException) {
                MovieBuffsUiState.Error
            }
        }
    }
}