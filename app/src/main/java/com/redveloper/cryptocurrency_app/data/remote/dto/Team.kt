package com.redveloper.cryptocurrency_app.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.redveloper.cryptocurrency_app.domain.model.TeamMember

data class Team(
    @SerializedName("id")
    val id: String?,
    @SerializedName("team")
    val name: String?,
    @SerializedName("position")
    val position: String?
)

fun Team.toTeamMember(): TeamMember {
    return TeamMember(
        id = id ?: "",
        name = name ?: "",
        position = position ?: ""
    )
}