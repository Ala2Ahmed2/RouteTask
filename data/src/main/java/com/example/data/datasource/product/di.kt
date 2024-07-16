package com.example.data.datasource.product

import com.example.data.contract.product.ProductsOnlineDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductsOnlineDataSourceModule {
    @Binds
    abstract fun bindProducts(impl: ProductsOnlineDataSourceImpl): ProductsOnlineDataSource
}
