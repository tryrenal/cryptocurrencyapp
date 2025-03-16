package com.redveloper.cryptocurrency_app.domain.usecase.get_coin

import com.redveloper.cryptocurrency_app.common.Resource
import com.redveloper.cryptocurrency_app.data.remote.dto.toCoin
import com.redveloper.cryptocurrency_app.data.remote.dto.toCoinDetail
import com.redveloper.cryptocurrency_app.domain.model.Coin
import com.redveloper.cryptocurrency_app.domain.model.CoinDetail
import com.redveloper.cryptocurrency_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>>{
        return flow {
            try{
                emit(Resource.Loading())

                val coin = repository.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success(coin))
            }
            catch (e: HttpException){
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
            catch (e: IOException){
                emit(Resource.Error("Couldnt reach server, check internet"))
            }
        }
    }

}