package com.rodriguezmauro.nonnapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodriguezmauro.nonnapp.domain.model.Recipe
import com.rodriguezmauro.nonnapp.domain.GetFirstRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val firstRecipeUseCase: GetFirstRecipeUseCase
) : ViewModel() {
    val recipeModel = MutableLiveData<Recipe>()

    fun onCreate() {
        viewModelScope.launch {
            val firstRecipe = firstRecipeUseCase()
            recipeModel.postValue(firstRecipe)
        }
    }
}