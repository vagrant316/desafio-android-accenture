package com.example.accenture.ui.repository

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.accenture.databinding.FragmentRepositoryBinding
import com.example.accenture.core.UiState
import com.example.accenture.presentation.repository.RepositoryViewModel
import com.example.accenture.presentation.repository.model.PullRequestItem
import com.example.accenture.presentation.repository.model.RepositoryItem
import com.example.accenture.ui.repository.adapter.RepositoryAdapter
import kotlinx.coroutines.flow.FlowCollector
import org.koin.androidx.viewmodel.ext.android.viewModel


class RepositoryFragment : Fragment() {
    private lateinit var binding: FragmentRepositoryBinding
    private val viewModel by viewModel<RepositoryViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentRepositoryBinding.inflate(inflater, container, false)
    //    (requireActivity() as AppCompatActivity).supportActionBar?.title = "Hello"

       // requireActivity().title = "Github JavaPop"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            viewModel.uiStatePullRequest.collect{
                uiStateCollector(it)
            }
        }
        viewModel.fetchPullRequest("kdn251", "interviews")
    }


     fun uiStateCollector(uiState:UiState<List<PullRequestItem>> ){
        with(binding){
            val algo: UiState<List<PullRequestItem>> = uiState
            when(uiState){
                is UiState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is UiState.Success ->{
                    progressBar.visibility = View.GONE
                    recyclerView.adapter = RepositoryAdapter(uiState.resource)
                }
                else -> Unit
            }
        }

    }




}