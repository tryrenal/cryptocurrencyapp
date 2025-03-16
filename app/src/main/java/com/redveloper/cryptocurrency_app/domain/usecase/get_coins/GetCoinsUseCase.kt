package com.redveloper.cryptocurrency_app.domain.usecase.get_coins

import com.redveloper.cryptocurrency_app.common.Resource
import com.redveloper.cryptocurrency_app.data.remote.dto.toCoin
import com.redveloper.cryptocurrency_app.domain.model.Coin
import com.redveloper.cryptocurrency_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>>{
        return flow {
            try{
                emit(Resource.Loading())

                val coins = repository.getCoins()
                emit(Resource.Success(
                    coins.map { it.toCoin() }
                ))
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