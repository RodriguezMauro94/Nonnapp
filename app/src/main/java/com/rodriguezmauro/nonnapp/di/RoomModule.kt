package com.rodriguezmauro.nonnapp.di

import android.content.Context
import androidx.room.Room
import com.rodriguezmauro.nonnapp.data.database.RecipeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val RECIPES_DATABASE_NAME = "recipesDatabase"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)
        = Room.databaseBuilder(context, RecipeDatabase::class.java, RECIPES_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(db: RecipeDatabase) = db.getRecipeDao()
}