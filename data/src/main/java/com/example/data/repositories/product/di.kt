package com.example.data.repositories.product

import com.example.data.repositories.product.ProductsRepositoryImpl
import com.example.domain.contract.product.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun bindProductsRepo(impl: ProductsRepositoryImpl): ProductsRepository
}
