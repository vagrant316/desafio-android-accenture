package com.example.accenture.ui.repository

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.accenture.R
import com.example.accenture.databinding.FragmentRepositoryBinding
import com.example.accenture.presentation.repository.RepositoryUiState
import com.example.accenture.presentation.repository.RepositoryViewModel
import com.example.accenture.presentation.repository.model.RepositoryItem
import com.example.accenture.ui.repository.adapter.RepositoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class RepositoryFragment : Fragment() {
    private var binding: FragmentRepositoryBinding? = null
    private val viewModel by viewModel<RepositoryViewModel>()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentRepositoryBinding.inflate(inflater, container, false)
        }
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collect{ uiState ->
                binding?.apply {
                    when(uiState){
                        is RepositoryUiState.Loading -> {
                            progressBar.visibility = View.VISIBLE
                            getActivity()?.setTitle("Github JavaPop");

                        }
                        is RepositoryUiState.Success ->{
                            progressBar.visibility = View.GONE
                            recyclerView.adapter = RepositoryAdapter(uiState.repositoryItem)
                        }
                        else -> Unit
                    }
                }

            }
        }
    }




}