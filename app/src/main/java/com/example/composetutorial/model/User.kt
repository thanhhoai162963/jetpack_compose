package com.example.composetutorial.model

import com.google.gson.annotations.SerializedName

data class User(
    var data: Data?,
    var support: Support?
) {
    constructor() : this(null, null)
}

data class Data(
    val id: Int?,
    val email: String?,
    @SerializedName("first_name") val firstName: String?,
    @SerializedName("last_name") val lastName: String?,
    @SerializedName("avatar") val avatar: String?,
)

data class Support(
    val id: Int,
    val url: String?,
    val text: String?,
)



