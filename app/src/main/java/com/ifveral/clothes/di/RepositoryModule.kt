package com.ifveral.clothes.di

import com.ifveral.clothes.api.FakeStoreAPI
import com.ifveral.clothes.repositories.ApiRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun getRepository(fakeStoreAPI: FakeStoreAPI) = ApiRepository(fakeStoreAPI)
}
