package com.krstudio.mymoviecatalogue.dto

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)