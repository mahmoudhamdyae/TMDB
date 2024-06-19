package com.mahmoudhamdyae.tmdb.core.di

import com.mahmoudhamdyae.tmdb.movies.data.remote.MoviesRemoteDataSource
import com.mahmoudhamdyae.tmdb.movies.data.remote.MoviesRemoteDataSourceImpl
import com.mahmoudhamdyae.tmdb.movies.data.repository.MoviesRepositoryImpl
import com.mahmoudhamdyae.tmdb.movies.domain.repository.MoviesRepository
import com.mahmoudhamdyae.tmdb.movies.domain.use_cases.GetPopularMoviesUseCase
import com.mahmoudhamdyae.tmdb.movies.representations.view_models.MoviesViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<HttpClient> {
        HttpClient(CIO) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
            install(ContentNegotiation) {
                json()
            }
        }
    }
    single<MoviesRemoteDataSource> {
        MoviesRemoteDataSourceImpl(get<HttpClient>())
    }
    single<MoviesRepository> {
        MoviesRepositoryImpl(get<MoviesRemoteDataSource>())
    }
    single<GetPopularMoviesUseCase> {
        GetPopularMoviesUseCase(get<MoviesRepository>())
    }
    viewModel<MoviesViewModel> {
        MoviesViewModel(get<GetPopularMoviesUseCase>())
    }
}