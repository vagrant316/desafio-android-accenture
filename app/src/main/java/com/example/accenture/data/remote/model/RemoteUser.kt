package com.example.accenture.data.remote.model

import com.example.accenture.data.remote.model.Constants.AVATAR_URL
import com.example.accenture.data.remote.model.Constants.LOGIN
import com.google.gson.annotations.SerializedName

data class RemoteUser(
    @SerializedName(LOGIN)
    val login: String?,
    @SerializedName(AVATAR_URL)
    val avatar_url: String?,
)
