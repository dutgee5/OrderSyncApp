package com.thedone.ordersyncapp.di

import com.thedone.ordersyncapp.data.repository.OrderRepositoryImpl
import com.thedone.ordersyncapp.domain.repository.OrderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepositoryImpl(
        orderRepositoryImpl: OrderRepositoryImpl,
    ): OrderRepository
}