package com.first.testingjetpackcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.first.testingjetpackcompose.pagination.data.remote.models.modelsQuotes.Quotes
import com.first.testingjetpackcompose.pagination.data.remote.models.repository.QuotesRepository
import com.first.testingjetpackcompose.pagination.utils.Graph
import kotlinx.coroutines.flow.Flow


class QuotesViewModel(

    private val quotesRepository:
    QuotesRepository = Graph.repository

): ViewModel() {

    val quotes: Flow<PagingData<Quotes>> = quotesRepository
        .getQuotes().cachedIn(viewModelScope)

}