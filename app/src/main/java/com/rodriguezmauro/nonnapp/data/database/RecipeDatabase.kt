package com.rodriguezmauro.nonnapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rodriguezmauro.nonnapp.data.database.dao.RecipeDao
import com.rodriguezmauro.nonnapp.data.database.entities.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1)
abstract class RecipeDatabase: RoomDatabase() {
    abstract fun getRecipeDao(): RecipeDao
}