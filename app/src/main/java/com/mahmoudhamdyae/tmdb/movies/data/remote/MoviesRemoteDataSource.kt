package com.mahmoudhamdyae.tmdb.movies.data.remote

import com.mahmoudhamdyae.tmdb.core.error.ServerException
import com.mahmoudhamdyae.tmdb.core.network.ApiConstants
import com.mahmoudhamdyae.tmdb.core.network.ErrorModel
import com.mahmoudhamdyae.tmdb.movies.data.remote.models.MoviesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode

interface MoviesRemoteDataSource {
    suspend fun getPopularMovies(): MoviesResponse
}

class MoviesRemoteDataSourceImpl(
    private val client: HttpClient
): MoviesRemoteDataSource {


    override suspend fun getPopularMovies(): MoviesResponse {
        val response: HttpResponse = client.get(ApiConstants.GET_POPULAR_MOVIES_PATH)
        if (response.status == HttpStatusCode.OK) {
            return response.body<MoviesResponse>()
        } else {
            throw ServerException(response.body<ErrorModel>())
        }
    }
}