package com.rodriguezmauro.nonnapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rodriguezmauro.nonnapp.domain.model.Recipe

@Entity(tableName = "recipe_table")
class RecipeEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "image")
    val image: String
)

fun Recipe.toDatabase() = RecipeEntity(title = title, description = description, image = image)