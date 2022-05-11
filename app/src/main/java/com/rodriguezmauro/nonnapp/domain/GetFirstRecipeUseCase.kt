package com.rodriguezmauro.nonnapp.domain

import com.rodriguezmauro.nonnapp.data.database.entities.toDatabase
import com.rodriguezmauro.nonnapp.domain.model.Recipe
import com.rodriguezmauro.nonnapp.data.model.RecipeRepository
import javax.inject.Inject

class GetFirstRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(): Recipe {
        var recipes = repository.getAllRecipesFromDatabase()

        if (recipes.isEmpty()) {
            recipes = repository.getAllRecipesFromApi()
            repository.insertRecipes(recipes.map {
                it.toDatabase()
            })
        }

        return recipes.random()
    }
}