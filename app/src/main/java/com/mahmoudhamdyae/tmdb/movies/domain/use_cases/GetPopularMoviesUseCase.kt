package com.mahmoudhamdyae.tmdb.movies.domain.use_cases

import com.mahmoudhamdyae.tmdb.core.network.ApiResponse
import com.mahmoudhamdyae.tmdb.movies.data.remote.models.MovieRemote
import com.mahmoudhamdyae.tmdb.movies.domain.repository.MoviesRepository

class GetPopularMoviesUseCase(
    private val repository: MoviesRepository
) {

    suspend operator fun invoke(): ApiResponse<List<MovieRemote>> {
        return repository.getPopularMovies()
    }
}