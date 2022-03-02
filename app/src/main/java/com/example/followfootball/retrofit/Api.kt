package com.example.followfootball.retrofit

class Api {

    companion object{

        val BASE_URL = "https://v3.football.api-sports.io/"
        fun getDaoInterface(): DaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(DaoInterface::class.java)

        }
    }

}