package com.example.accenture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.accenture.data.GithubRepository

class MainViewModel(private val repository: GithubRepository): ViewModel() {

    private var _count: MutableLiveData<Int> = MutableLiveData()
    val count: LiveData<Int> = _count

    init {
        _count.value = repository.getData()
    }

    fun increase(){
        _count.value = count.value?.plus(1)
    }
}