package com.example.data.api.wepServices

import com.example.data.api.model.ProductDto
import kotlinx.coroutines.flow.Flow
import com.example.data.api.model.Response
import retrofit2.http.GET

interface ProductWebServices {
    @GET("/products")
    suspend fun getProducts(): Response
}