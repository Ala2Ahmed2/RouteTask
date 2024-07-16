package com.example.domain.contract.product

import com.example.domain.common.Resource
import com.example.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProducts(): Flow<Resource<List<Product>?>>
}