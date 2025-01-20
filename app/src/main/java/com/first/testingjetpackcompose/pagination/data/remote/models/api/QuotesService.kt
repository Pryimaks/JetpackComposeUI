package com.first.testingjetpackcompose.pagination.data.remote.models.api

import com.first.testingjetpackcompose.pagination.data.remote.models.ApiQuotes
import com.first.testingjetpackcompose.pagination.utils.K
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesService {

    @GET(K.API_END_POINTS)
    suspend fun getQuotes(
        
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("genre") genre: String = "motivational"
        
    ): ApiQuotes
    
}
