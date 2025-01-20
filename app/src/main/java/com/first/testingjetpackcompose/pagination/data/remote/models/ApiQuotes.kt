package com.first.testingjetpackcompose.pagination.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Serializable
data class ApiQuotes(

    @SerialName("data")
    val data: List<Data> = listOf(),

    @SerialName("message")
    val message: String = "",

    @SerialName("pagination")
    val pagination: Pagination = Pagination(),

    @SerialName("statusCode")
    val statusCode: Int = 0,

    @SerialName("totalQuotes")
    val totalQuotes: Int = 0

)
