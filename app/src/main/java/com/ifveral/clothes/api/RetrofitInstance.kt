package com.ifveral.clothes.api

import com.ifveral.clothes.utility.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: FakeStoreAPI by lazy {
        retrofit.create(FakeStoreAPI::class.java)
    }
}