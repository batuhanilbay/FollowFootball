package com.example.followfootball.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class League(

    @SerializedName("id"   )    val id   : Int? ,
    @SerializedName("name" )    val name : String? ,
    @SerializedName("type" )    val type : String? ,
    @SerializedName("logo" )    val logo : String? ) : Serializable {}

data class Seasons(

    @SerializedName("year"     )    val year     : Int?,
    @SerializedName("current"  )    val current  : Boolean?,
    @SerializedName("coverage" )    val coverage : Coverage? ) : Serializable{}

data class Coverage(


    @SerializedName("fixtures"    ) val fixtures    : Fixtures? ,
    @SerializedName("standings"   ) val standings   : Boolean? ) : Serializable{}

data class Fixtures(

    @SerializedName("events")       val events : Boolean? ,
    @SerializedName("lineups")      val lineups : Boolean?,
    @SerializedName("statistics_fixtures") val statistics_fixtures : Boolean?,
    @SerializedName("statistics_players")  val statistics_players : Boolean?) : Serializable{}

data class LeagueResponse(

    @SerializedName("league")   val league: League? ,
    @SerializedName("country")  val country: Countries?,
    @SerializedName("seasons")  val seasons: ArrayList<Seasons> = arrayListOf(),
    @SerializedName("response") val response: List<LeagueResponse> ) : Serializable{}