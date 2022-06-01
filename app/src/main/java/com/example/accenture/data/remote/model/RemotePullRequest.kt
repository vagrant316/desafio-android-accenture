package com.example.accenture.data.remote.model

import com.google.gson.annotations.SerializedName

data class RemotePullRequest(
    @SerializedName(Constants.TITLE)
    val title: String?,
    @SerializedName(Constants.BODY)
    val body: String?,
    @SerializedName(Constants.USER)
    val remoteUser: RemoteUser?,
)