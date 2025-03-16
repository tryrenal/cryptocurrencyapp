package com.redveloper.cryptocurrency_app.domain.repository

import com.redveloper.cryptocurrency_app.data.remote.dto.CoinDetailDto
import com.redveloper.cryptocurrency_app.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}