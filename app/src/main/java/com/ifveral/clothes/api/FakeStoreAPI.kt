package com.ifveral.clothes.api

import com.ifveral.clothes.model.ProductListItem
import com.ifveral.clothes.model.ProductListResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface FakeStoreAPI {
    @GET("products")
    suspend fun getProductList(): ProductListResponse

    @GET("products/{product_id}")
    suspend fun getProductDetail(@Path("product_id") id: String): ProductListItem

}