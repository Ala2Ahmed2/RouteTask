package com.example.data.datasource.product

import com.example.data.api.wepServices.ProductWebServices
import com.example.data.contract.product.ProductsOnlineDataSource
import com.example.data.executeApi
import com.example.domain.models.Product
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductsOnlineDataSourceImpl
@Inject
constructor(
    private val webServices: ProductWebServices,
) : ProductsOnlineDataSource {
    override suspend fun getProducts(): List<Product>? {
        val response =
            executeApi {
                webServices.getProducts()
            }
        return response.products?.filterNotNull()?.map {
            it.toProduct()
        }
    }
}