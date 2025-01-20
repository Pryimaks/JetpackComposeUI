package com.first.testingjetpackcompose.pagination.data.remote.models.repository

import androidx.paging.PagingData
import com.first.testingjetpackcompose.pagination.data.remote.models.modelsQuotes.Quotes
import kotlinx.coroutines.flow.Flow


interface QuotesRepository {

    fun getQuotes(): Flow<PagingData<Quotes>>

}