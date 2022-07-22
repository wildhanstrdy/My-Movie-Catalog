package com.krstudio.mymoviecatalogue

import io.ktor.client.*

expect class Platform() {
    val platform: String
    val httpClient: HttpClient
}
