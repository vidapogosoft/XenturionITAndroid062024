package com.android.apirest

import com.google.gson.annotations.SerializedName

data class DogInfo (

    @SerializedName("userId") var userId: Int,
    @SerializedName("title") var title: String,
    @SerializedName("body") var body: String

        )
