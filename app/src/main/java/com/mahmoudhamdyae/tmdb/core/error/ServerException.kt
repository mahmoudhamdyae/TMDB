package com.mahmoudhamdyae.tmdb.core.error

import com.mahmoudhamdyae.tmdb.core.network.ErrorModel

class ServerException(val error: ErrorModel): Exception()