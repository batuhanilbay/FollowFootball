package com.example.followfootball.retrofit

import com.example.followfootball.model.CountryResponse
import com.example.followfootball.model.LeagueResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Streaming

interface DaoInterface {


    //Countries --> https://v3.football.api-sports.io/countries
    @Streaming
    @GET("countries")
    fun allCountries(@Header("x-rapidapi-key")api_key : String, @Header("x-rapidapi-host") host_name:String ) : Call<CountryResponse>

    /*@Streaming
    @GET("https://media.api-sports.io/flags/{country_code}.svg")
    fun getFlag(flag:String): Call<CountryResponse>*/

    //Leagues --> https://v3.football.api-sports.io/leagues
     @Streaming
     @GET("leagues")
     fun allLeagues(@Header("x-rapidapi-key")api_key: String, @Header("x-rapidapi-host") host_name:String ) : Call<LeagueResponse>



    /*//Standings --> https://v3.football.api-sports.io/standings
    @Streaming
    @GET("standings")
    fun allStandings(@Header("x-rapidapi-key")api_key: String,
                     @Header("x-rapidapi-host") host_name: String,
                     @Query("league") league:String,
                     @Query("season") season:Int): Call<ResponseStandings>*/


}