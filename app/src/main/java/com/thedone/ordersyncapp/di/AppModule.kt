package com.thedone.ordersyncapp.di

import com.thedone.ordersyncapp.data.remote.OrderSyncApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOrderSyncApi(): OrderSyncApi {
        return Retrofit.Builder()
            .baseUrl(OrderSyncApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OrderSyncApi::class.java)
    }
}