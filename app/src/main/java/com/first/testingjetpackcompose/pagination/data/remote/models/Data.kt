package com.first.testingjetpackcompose.pagination.data.remote.models

import com.first.testingjetpackcompose.pagination.data.remote.models.modelsQuotes.Quotes
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(

    @SerialName("_id")
    val id: String = "",

    @SerialName("quoteAuthor")
    val quoteAuthor: String = "",

    @SerialName("quoteGenre")
    val quoteGenre: String = "",

    @SerialName("quoteText")
    val quoteText: String = "",

    @SerialName("__v")
    val v: Int = 0

)


fun Data.toQuotes(currentPage: Int): Quotes {

    return Quotes(

        id = id,
        quoteAuthor = quoteAuthor,
        quoteGenre = quoteGenre,
        quoteText = quoteText,
        currentPage = currentPage

    )

}
