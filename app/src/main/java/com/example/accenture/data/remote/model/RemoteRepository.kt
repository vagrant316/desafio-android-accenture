package com.example.accenture.data.remote.model

import com.example.accenture.data.remote.model.Constants.REPOSITORY_ITEMS
import com.google.gson.annotations.SerializedName

data class RemoteRepository (
    @SerializedName(REPOSITORY_ITEMS)
    val repositoryItems: List<RemoteRepositoryItem>?
)