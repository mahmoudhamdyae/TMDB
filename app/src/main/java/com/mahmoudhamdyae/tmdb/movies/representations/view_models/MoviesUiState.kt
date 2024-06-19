package com.mahmoudhamdyae.tmdb.movies.representations.view_models

import com.mahmoudhamdyae.tmdb.core.network.ApiResponse
import com.mahmoudhamdyae.tmdb.movies.data.remote.models.MovieRemote

data class MoviesUiState(
    val popularMoviesState: ApiResponse<List<MovieRemote>> = ApiResponse.Loading(),
)
