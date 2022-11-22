package com.ifveral.clothes.ui.catalogue.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifveral.clothes.model.ProductListItem
import com.ifveral.clothes.repositories.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    ViewModel() {
    private val productDetailLiveData = MutableLiveData<ProductListItem>()
    val productDetail: LiveData<ProductListItem> = productDetailLiveData

    fun getProductDetail(product_id: String) {
        viewModelScope.launch {
            val productDetail = apiRepository.getProductDetail(product_id)
            delay(1000)
            productDetailLiveData.value = productDetail
        }
    }
}