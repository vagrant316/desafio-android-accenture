package com.example.accenture.data.remote.model

import com.example.accenture.data.remote.model.Constants.AVATAR_URL
import com.example.accenture.data.remote.model.Constants.LOGIN
import com.google.gson.annotations.SerializedName

data class RemoteOwner(
    @SerializedName(LOGIN)
    val login: String?,
    @SerializedName(AVATAR_URL)
    val avatarUrl: String?,
)

