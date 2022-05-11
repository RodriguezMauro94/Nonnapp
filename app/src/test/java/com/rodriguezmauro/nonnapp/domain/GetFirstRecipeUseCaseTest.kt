package com.rodriguezmauro.nonnapp.domain

import com.rodriguezmauro.nonnapp.data.model.RecipeRepository
import com.rodriguezmauro.nonnapp.domain.model.Recipe
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetFirstRecipeUseCaseTest {
    @RelaxedMockK
    private lateinit var repository: RecipeRepository
    lateinit var getFirstRecipeUseCase: GetFirstRecipeUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getFirstRecipeUseCase = GetFirstRecipeUseCase(repository)
    }

    @Test
    fun `when the database returns an empty list, fetch in the api`() = runBlocking {
        // Given
        coEvery { repository.getAllRecipesFromDatabase() } returns emptyList()
        val recipe = listOf(Recipe("mockImage", "mockTitle", "mockDescription"))
        coEvery { repository.getAllRecipesFromApi() } returns recipe

        // When
        val result = getFirstRecipeUseCase()

        // Then
        coVerify(exactly = 1) {
            repository.getAllRecipesFromApi()
            repository.insertRecipes(any())
        }
        assert(result == recipe[0])
    }
}