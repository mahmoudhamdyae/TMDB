package com.mahmoudhamdyae.tmdb.movies.representations.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudhamdyae.tmdb.movies.domain.use_cases.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(MoviesUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getPopularMovies()
    }

    private fun getPopularMovies() {
        viewModelScope.launch {
            _uiState.value = MoviesUiState(
                popularMoviesState = getPopularMoviesUseCase()
            )
        }
    }
}