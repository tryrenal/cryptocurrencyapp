package com.redveloper.cryptocurrency_app.presentation.coin_detail

import com.redveloper.cryptocurrency_app.domain.model.Coin
import com.redveloper.cryptocurrency_app.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
