package com.mahmoudhamdyae.tmdb.movies.data.repository

import com.mahmoudhamdyae.tmdb.core.error.Failure
import com.mahmoudhamdyae.tmdb.core.error.ServerException
import com.mahmoudhamdyae.tmdb.core.network.ApiResponse
import com.mahmoudhamdyae.tmdb.movies.data.remote.MoviesRemoteDataSource
import com.mahmoudhamdyae.tmdb.movies.data.remote.models.MovieRemote
import com.mahmoudhamdyae.tmdb.movies.domain.repository.MoviesRepository

class MoviesRepositoryImpl(
    private val remoteDataSource: MoviesRemoteDataSource
): MoviesRepository {

    override suspend fun getPopularMovies(): ApiResponse<List<MovieRemote>> {
        return try {
            ApiResponse.Success(remoteDataSource.getPopularMovies().movies)
        } catch (error: ServerException) {
            ApiResponse.Error(Failure(error.error.statusMessage))
        }
    }
}