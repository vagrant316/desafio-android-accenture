package com.example.accenture.data.remote.retrofit

import com.example.accenture.data.remote.model.RemotePullRequest
import com.example.accenture.data.remote.model.RemoteRepository
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubWebService {

    @GET("search/repositories?q=language:Java&sort=stars")
    suspend fun getRepository(
        @Query("page") page: Int
    ) : RemoteRepository

    @GET("repos/{creator}/{repo}/pulls")
    suspend fun getPullRequest(
        @Path("creator") creator: String,
        @Path("repo") repo: String

    ) : List<RemotePullRequest>
}