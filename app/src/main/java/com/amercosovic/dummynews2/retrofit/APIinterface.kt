package com.amercosovic.dummynews2.retrofit

import com.amercosovic.dummynews2.modelwithmandatorysearchonly.MandatorySearchOnly
import retrofit2.http.GET
import retrofit2.http.Query

interface APIinterface {
    @GET("svc/search/v2/articlesearch.json")
    suspend fun getMandatorySearchResult(@Query("q") query: String, @Query("api-key") api_key: String ): MandatorySearchOnly

    @GET("svc/search/v2/articlesearch.json")
    suspend fun getSearchResultWithBeginDateOnly(@Query("q") query: String,@Query("begin_date") begin_date: String,
                                                 @Query("api-key") api_key: String ): MandatorySearchOnly

    @GET("svc/search/v2/articlesearch.json")
    suspend fun getSearchResultWithEndDateOnly(@Query("q") query: String,@Query("end_date") end_date: String,
                                                 @Query("api-key") api_key: String ): MandatorySearchOnly

    @GET("svc/search/v2/articlesearch.json")
    suspend fun getSearchResultWithBeginDateAndEndDate(@Query("q") query: String,@Query("begin_date") begin_date: String,
                                                       @Query("end_date")end_date: String, @Query("api-key") api_key: String ): MandatorySearchOnly

    @GET("svc/search/v2/articlesearch.json")
    suspend fun getSearchResultWithBeginDateEndDateAndCheckbox(@Query("q") query: String,@Query("begin_date") begin_date: String,
                                                       @Query("end_date")end_date: String,
                                                     @Query("fq")category: String, @Query("api-key") api_key: String ): MandatorySearchOnly

    @GET("svc/search/v2/articlesearch.json")
    suspend fun getSearchResultWithCheckbox(@Query("q") query: String, @Query("fq")category: String,
                                                  @Query("api-key") api_key: String ): MandatorySearchOnly
}
