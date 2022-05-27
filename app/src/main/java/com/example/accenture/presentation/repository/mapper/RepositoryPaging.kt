package com.example.accenture.presentation.repository.mapper

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.accenture.data.remote.model.RemoteRepositoryItem
import com.example.accenture.data.remote.retrofit.GitHubWebService

class RepositoryPaging(private val webService: GitHubWebService) :
    PagingSource<Int, RemoteRepositoryItem>() {

    override fun getRefreshKey(state: PagingState<Int, RemoteRepositoryItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RemoteRepositoryItem> {
        return try {
            val currentPage = params.key ?: 1
            val response = webService.getRepository(currentPage)
            val repoList = response.repositoryItems


            LoadResult.Page(
                data = repoList.orEmpty(),
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


}