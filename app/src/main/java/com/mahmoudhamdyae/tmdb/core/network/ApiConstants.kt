package com.mahmoudhamdyae.tmdb.core.network

object ApiConstants {
    private const val BASE_URL: String = "https://api.themoviedb.org/3"
    private const val API_KEY: String = "308fc9935783b6199369f60243c21395"

    // Movies
    const val GET_NOW_PLAYING_MOVIES_PATH = "$BASE_URL/movie/now_playing?api_key=$API_KEY"
    const val GET_POPULAR_MOVIES_PATH = "$BASE_URL/movie/popular2?api_key=$API_KEY"
    const val GET_TOP_RATED_MOVIES_PATH = "$BASE_URL/movie/top_rated?api_key=$API_KEY"
    fun getMovieDetailsPath(movieId: Int) = "$BASE_URL/movie/$movieId?api_key=$API_KEY"
    fun searchMovie(query: String) = "$BASE_URL/search/movie?api_key=$API_KEY"
    fun getMovieReviews(movieId: Int) = "movie/$movieId/reviews?api_key=$API_KEY"
    fun getMovieTrailers(movieId: Int) = "movie/$movieId/videos?api_key=$API_KEY"

    // TV
    const val GET_NOW_PLAYING_TV_PATH = "$BASE_URL/tv/now_playing?api_key=$API_KEY"
    const val GET_POPULAR_TV_PATH = "$BASE_URL/tv/popular?api_key=$API_KEY"
    const val GET_TOP_RATED_TV_PATH = "$BASE_URL/tv/top_rated?api_key=$API_KEY"
    fun getTVDetailsPath(tvId: Int) = "$BASE_URL/tv/$tvId?api_key=$API_KEY"
    fun searchTV(query: String) = "$BASE_URL/search/tv?api_key=$API_KEY"
    fun getTVReviews(tvId: Int) = "tv/$tvId/reviews?api_key=$API_KEY"
    fun getTVTrailers(tvId: Int) = "tv/$tvId/videos?api_key=$API_KEY"

    fun recommendationPath(movieId: Int) = "$BASE_URL/movie/$movieId/recommendations?api_key=$API_KEY"

    private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    fun getImage(path: String) = "$BASE_IMAGE_URL$path"
}