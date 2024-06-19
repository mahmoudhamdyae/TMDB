package com.mahmoudhamdyae.tmdb.movies.domain.repository

import com.mahmoudhamdyae.tmdb.core.network.ApiResponse
import com.mahmoudhamdyae.tmdb.movies.data.remote.models.MovieRemote

interface MoviesRepository {
    suspend fun getPopularMovies(): ApiResponse<List<MovieRemote>>
}