package com.example.followfootball.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CountryResponse (

        @SerializedName("response") val response: List<Countries>) : Serializable{}


data class Countries(

        @SerializedName("code")     val code: String,
        @SerializedName("flag")     val flag: String,
        @SerializedName("name")     val name: String ): Serializable {}