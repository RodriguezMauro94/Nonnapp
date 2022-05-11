package com.rodriguezmauro.nonnapp.data.network

import com.rodriguezmauro.nonnapp.data.model.RecipeModel
import retrofit2.Response
import retrofit2.http.GET

interface RecipeApiClient {
    @GET("recipes")
    suspend fun getAllRecipes(): Response<List<RecipeModel>>
}