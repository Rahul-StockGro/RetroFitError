package com.rahul.retrofiterror

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/v2/5ecce1a03200007700236438")
    fun getMock() : Call<SuccessResponse>

    @GET("/v2/5185415ba171ea3a00704eed")
    fun getMock2() : Call<SuccessResponse>
    @GET("/v2/5eccf510320000730023652f")
    fun getMock3() : Call<SuccessResponse>
}