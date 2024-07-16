package com.example.data.repositories.product

import com.google.gson.Gson
import com.example.data.api.model.Response
import com.example.data.contract.product.ProductsOnlineDataSource
import com.example.data.toFlow
import com.example.domain.common.InternetConnectionError
import com.example.domain.common.Resource
import com.example.domain.common.ServerError
import com.example.domain.contract.product.ProductsRepository
import com.example.domain.models.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class ProductsRepositoryImpl
@Inject
constructor(
    private val productsOnlineDataSource: ProductsOnlineDataSource,
) : ProductsRepository {
    override suspend fun getProducts(): Flow<Resource<List<Product>?>> =
        toFlow {
            productsOnlineDataSource.getProducts()
        }
}