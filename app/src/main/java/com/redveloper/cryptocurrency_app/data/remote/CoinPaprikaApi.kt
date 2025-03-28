package com.redveloper.cryptocurrency_app.data.remote

import com.redveloper.cryptocurrency_app.data.remote.dto.CoinDetailDto
import com.redveloper.cryptocurrency_app.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coindId}")
    suspend fun getCoinById(@Path("coindId") coinId: String): CoinDetailDto
}