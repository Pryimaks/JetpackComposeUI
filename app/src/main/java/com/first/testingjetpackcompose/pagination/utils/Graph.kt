package com.first.testingjetpackcompose.pagination.utils

import android.content.Context
import com.first.testingjetpackcompose.pagination.data.remote.models.api.QuotesService
import com.first.testingjetpackcompose.pagination.data.remote.models.repository.QuotesRepository
import com.first.testingjetpackcompose.pagination.data.remote.models.repository.QuotesRepositoryImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
/*
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit



object Graph {

    private val json = Json{

        coerceInputValues = true
        ignoreUnknownKeys = true

    }

    lateinit var api: QuotesService

    val repository: QuotesRepository by lazy {

        QuotesRepositoryImpl(api)

    }

    @OptIn(ExperimentalSerializationApi::class)
    fun provide(context: Context){

        val contentType = "application/json".toMediaType()

        api = Retrofit.Builder()
            .baseUrl(K.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(QuotesService::class.java)

    }

}

 */