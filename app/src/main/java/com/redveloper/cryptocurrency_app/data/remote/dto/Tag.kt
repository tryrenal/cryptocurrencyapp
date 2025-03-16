package com.redveloper.cryptocurrency_app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("coinCounter")
    val coinCounter: Int,
    @SerializedName("icoCounter")
    val icoCounter: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)