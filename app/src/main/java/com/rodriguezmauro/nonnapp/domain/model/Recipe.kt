package com.rodriguezmauro.nonnapp.domain.model

import com.rodriguezmauro.nonnapp.data.database.entities.RecipeEntity
import com.rodriguezmauro.nonnapp.data.model.RecipeModel

data class Recipe(val image: String, val title: String, val description: String)

fun RecipeEntity.toDomain() = Recipe(image = image, title = title, description = description)
fun RecipeModel.toDomain() = Recipe(image = image, title = title, description = description)