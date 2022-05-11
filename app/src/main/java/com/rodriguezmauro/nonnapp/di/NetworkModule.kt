package com.rodriguezmauro.nonnapp.di

import com.rodriguezmauro.nonnapp.data.network.RecipeApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofi(): Retrofit = Retrofit.Builder()
        .baseUrl("https://my-json-server.typicode.com/RodriguezMauro94/Nonnapp/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): RecipeApiClient {
        return retrofit.create(RecipeApiClient::class.java)
    }
}