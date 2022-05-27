package com.example.accenture.data.remote.model
import com.example.accenture.data.remote.model.Constants.DESCRIPTION
import com.example.accenture.data.remote.model.Constants.FORK_COUNT
import com.example.accenture.data.remote.model.Constants.ID
import com.example.accenture.data.remote.model.Constants.NAME
import com.example.accenture.data.remote.model.Constants.OWNER
import com.example.accenture.data.remote.model.Constants.STARGAZER_COUNT
import com.google.gson.annotations.SerializedName

data class RemoteRepositoryItem(
      @SerializedName(ID)
      val id: String?,
      @SerializedName(NAME)
      val name: String?,
      @SerializedName(DESCRIPTION)
      val description: String?,
      @SerializedName(OWNER)
      val remoteOwner: RemoteOwner?,
      @SerializedName(STARGAZER_COUNT)
      val stargazerCount: Int?,
      @SerializedName(FORK_COUNT)
      val forkCount: Int?
)
