package com.rodriguezmauro.nonnapp.data.model

import com.rodriguezmauro.nonnapp.data.database.dao.RecipeDao
import com.rodriguezmauro.nonnapp.data.database.entities.RecipeEntity
import com.rodriguezmauro.nonnapp.data.network.RecipeService
import com.rodriguezmauro.nonnapp.domain.model.Recipe
import com.rodriguezmauro.nonnapp.domain.model.toDomain
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val api: RecipeService,
    private val recipesDao: RecipeDao
) {
    suspend fun getAllRecipesFromApi(): List<Recipe> {
        return api.getRecipes().map {
            it.toDomain()
        }
    }

    suspend fun getAllRecipesFromDatabase(): List<Recipe> {
        return recipesDao.getAllRecipes().map {
            it.toDomain()
        }
    }

    suspend fun insertRecipes(recipes: List<RecipeEntity>) {
        recipesDao.insertAll(recipes)
    }
}
