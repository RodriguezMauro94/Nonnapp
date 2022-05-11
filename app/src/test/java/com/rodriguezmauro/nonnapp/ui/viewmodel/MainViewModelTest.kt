package com.rodriguezmauro.nonnapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rodriguezmauro.nonnapp.domain.GetFirstRecipeUseCase
import com.rodriguezmauro.nonnapp.domain.model.Recipe
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {
    @RelaxedMockK
    private lateinit var getFirstRecipeUseCase: GetFirstRecipeUseCase
    private lateinit var mainViewModel: MainViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        mainViewModel = MainViewModel(getFirstRecipeUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewModel is created at the first time, get one recipe and set the value`() = runTest {
        // Given
        val recipe = Recipe("mockImage", "mockTitle", "mockDescription")
        coEvery { getFirstRecipeUseCase() } returns recipe

        // When
        mainViewModel.onCreate()

        // Then
        assert(mainViewModel.recipeModel.value == recipe)
    }
}