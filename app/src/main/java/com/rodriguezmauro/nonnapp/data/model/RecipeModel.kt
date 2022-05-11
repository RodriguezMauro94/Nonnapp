package com.rodriguezmauro.nonnapp.data.model

import com.google.gson.annotations.SerializedName

data class RecipeModel(
    @SerializedName("image") val image: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String)