package com.krstudio.mymoviecatalogue

import co.touchlab.stately.freeze
import com.krstudio.mymoviecatalogue.dto.Movie
import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class APIService() {
    private val BASE_URL = "https://api.themoviedb.org/3/"

    @NativeCoroutineScope
    private val coroutineScope: CoroutineScope = MainScope()


    suspend fun getTopRatedMovies(): Movie {
        val movie:Movie =  Platform().httpClient.get(
            "${BASE_URL}movie/top_rated?api_key=0&language=en-US&page=1"
        ).body()
        return movie
    }
}
