package com.example.productsapp.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.models.Product
import com.example.domain.usecase.product.GetAllProductsUseCase
import com.example.productsapp.base.BaseViewModel
import com.example.productsapp.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel
@Inject
constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
) : BaseViewModel(),
    ProductContract.ProductsViewModel {
    private val _state = MutableStateFlow<ProductContract.State>(ProductContract.State.Loading)
    override val state: StateFlow<ProductContract.State>
        get() = _state

    private val _event = SingleLiveEvent<ProductContract.Event>()
    override val event: LiveData<ProductContract.Event>
        get() = _event

    override fun doAction(action: ProductContract.Action) {
        when (action) {
            is ProductContract.Action.LoadProducts -> {
                loadData()
            }
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            getAllProductsUseCase().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _state.emit(ProductContract.State.Success(resource.data))
                    }

                    else -> {
                        extractViewMessage(resource)?.let {
                            _event.postValue(ProductContract.Event.ShowMessage(it))
                        }
                    }
                }
            }
        }
    }
}
