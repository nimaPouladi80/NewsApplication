package com.newsapplication

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("top-headline")
    fun getNews(
        @Query("source") source: String,
        @Query("apiKey") apiKey: String
    ): Response<ResponseModel>


}  