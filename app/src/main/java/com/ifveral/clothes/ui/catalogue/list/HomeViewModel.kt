package com.ifveral.clothes.ui.catalogue.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifveral.clothes.model.ProductListResponse
import com.ifveral.clothes.repositories.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val apiRepository: ApiRepository) :
    ViewModel() {
    private val resultLiveData = MutableLiveData<ProductListResponse>()
    val result: LiveData<ProductListResponse> = resultLiveData

    init {
        viewModelScope.launch {
            val resultList = apiRepository.getProductList()
            delay(1000)
            resultLiveData.value = resultList
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "Categories"
    }
    val text: LiveData<String> = _text
}