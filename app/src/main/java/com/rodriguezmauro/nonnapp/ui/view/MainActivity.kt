package com.rodriguezmauro.nonnapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.rodriguezmauro.nonnapp.databinding.ActivityMainBinding
import com.rodriguezmauro.nonnapp.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.onCreate()

        mainViewModel.recipeModel.observe(this) {
            binding.tvRecipeTitle.text = it.title
            binding.tvRecipeDescription.text = it.description
        }
    }
}