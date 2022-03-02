package com.example.followfootball.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{
        const val API_KEY= "ceb5a94c51e9ec1ee939712f844796b7"
        fun getClient(baseUrl:String) : Retrofit {

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


    }

}