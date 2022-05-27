package com.example.accenture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.accenture.databinding.ActivityMainBinding
import com.example.accenture.presentation.repository.RepositoryUiState
import com.example.accenture.presentation.repository.RepositoryViewModel
import com.example.accenture.presentation.repository.model.RepositoryItem
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}