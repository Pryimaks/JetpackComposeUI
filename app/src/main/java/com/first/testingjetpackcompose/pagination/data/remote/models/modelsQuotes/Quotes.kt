package com.first.testingjetpackcompose.pagination.data.remote.models.modelsQuotes


data class Quotes(

    val id: String,
    val quoteAuthor: String,
    val quoteGenre: String,
    val quoteText: String,
    val currentPage: Int

)
