package com.jemery.got.di

import com.jemery.got.data.repository.GotRepositoryImpl
import com.jemery.got.domain.repository.GotRepository
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
    abstract fun bindGotRepository(
        randomizerRepository: GotRepositoryImpl
    ): GotRepository

}