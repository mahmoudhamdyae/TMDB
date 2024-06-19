package com.mahmoudhamdyae.tmdb.movies.representations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.mahmoudhamdyae.tmdb.movies.representations.view_models.MoviesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: MoviesViewModel = koinViewModel()
) {
    println("==============")
    val popularMoviesState = viewModel.uiState.collectAsState().value
    println(popularMoviesState.popularMoviesState.data)
    println(popularMoviesState.popularMoviesState.failure?.message)
}