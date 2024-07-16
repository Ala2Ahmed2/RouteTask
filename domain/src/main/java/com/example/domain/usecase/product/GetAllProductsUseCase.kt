package com.example.domain.usecase.product

import com.example.domain.common.Resource
import com.example.domain.contract.product.ProductsRepository
import com.example.domain.models.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProductsUseCase
@Inject
constructor(
    private val productsRepository: ProductsRepository,
) {
    suspend operator fun invoke(): Flow<Resource<List<Product>?>> = productsRepository.getProducts()
}