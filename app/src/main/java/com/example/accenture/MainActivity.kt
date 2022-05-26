package com.example.accenture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accenture.databinding.ActivityMainBinding
import com.example.accenture.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

        }

        viewModel.count.observe(this){

        }
    }
}