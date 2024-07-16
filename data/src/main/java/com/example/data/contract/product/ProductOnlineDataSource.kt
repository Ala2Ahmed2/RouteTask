package com.example.data.contract.product

import com.example.domain.models.Product

interface ProductsOnlineDataSource {
    suspend fun getProducts(): List<Product>?
}