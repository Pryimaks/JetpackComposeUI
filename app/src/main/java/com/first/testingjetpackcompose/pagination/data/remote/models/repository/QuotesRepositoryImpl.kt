package com.first.testingjetpackcompose.pagination.data.remote.models.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.first.testingjetpackcompose.pagination.data.remote.models.api.QuotesService
import com.first.testingjetpackcompose.pagination.data.remote.models.modelsQuotes.Quotes
import com.first.testingjetpackcompose.pagination.data.remote.models.pagination.QuotesPagingSource
import kotlinx.coroutines.flow.Flow


class QuotesRepositoryImpl(

    private val api: QuotesService

): QuotesRepository {

    override fun getQuotes(): Flow<PagingData<Quotes>> {

        return Pager(
            config = PagingConfig(pageSize = 20,
                enablePlaceholders = false),
            pagingSourceFactory = {
                QuotesPagingSource(api)
            }
        ).flow

    }

}