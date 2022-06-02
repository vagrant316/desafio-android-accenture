package com.example.accenture.presentation.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.accenture.core.UiState
import com.example.accenture.data.GithubRepository
import com.example.accenture.core.UiState.*
import com.example.accenture.presentation.repository.mapper.toPresentation
import com.example.accenture.presentation.repository.model.PullRequest
import com.example.accenture.presentation.repository.model.PullRequestItem
import com.example.accenture.presentation.repository.model.RepositoryItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class RepositoryViewModel(
    private val repository: GithubRepository
) : ViewModel() {

/*    private val _uiState = MutableStateFlow<UiState<List<RepositoryItem>>>(Empty())
    val uiState: StateFlow<UiState<List<RepositoryItem>>> = _uiState*/


  //  val uiStateRepository = MutableStateFlow<UiState<List<RepositoryItem>>>(Empty)

    val pullRequestFlow = MutableStateFlow<List<PullRequestItem>>(emptyList())
    val pullRequestLiveData = MutableLiveData<UiState>(Empty)


    /*fun fetchRepository() {
        viewModelScope.launch {
            repository.getRepository()
                .flowOn(Dispatchers.IO)
                .onStart {
                    uiStateRepository.value = Loading()
                }
                .catch { e ->
                    uiStateRepository.value = Error(e)
                }
                .collect { repository ->
                    val mapRepository = repository.toPresentation()
                    uiStateRepository.value = Success
                }
        }
    }*/

    fun fetchPullRequest(creator: String, repo: String) {
        viewModelScope.launch {
            repository.getPullRequest(creator, repo)
                .flowOn(Dispatchers.IO)
                .onStart {
                    pullRequestLiveData.postValue(Loading)
                }
                .catch { e ->
                    pullRequestLiveData.postValue(Error(e))
                }
                .map {
                    it.toPresentation()
                }
                .collect {
                    pullRequestFlow.emit(it)
                }
        }
    }
}
