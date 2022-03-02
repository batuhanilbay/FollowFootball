package com.example.followfootball.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.followfootball.model.LeagueResponse
import com.example.followfootball.retrofit.Api
import com.example.followfootball.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class LeagueFragmentViewModel  : ViewModel(){

    fun downloadLeague(){
        allGetLeague()
    }

    var leagueList : MutableLiveData<List<LeagueResponse>> = MutableLiveData()
    val leaguDaoInterface = Api.getDaoInterface()


    fun allGetLeague(){

        leaguDaoInterface.allLeagues(RetrofitClient.API_KEY, Api.BASE_URL).enqueue(object :
            retrofit2.Callback<LeagueResponse> {
            override fun onResponse(call: Call<LeagueResponse>?,
                                    leagueResponse: Response<LeagueResponse>?) {

                val liste = leagueResponse?.body()?.response
                liste?.apply {
                    var filteredData = filteredCodeData(liste)
                    leagueList.postValue(filteredData)
                }

            }

            override fun onFailure(call: Call<LeagueResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

    }

    //Filtering leagues
    fun filteredCodeData(codeList: List<LeagueResponse>): ArrayList<LeagueResponse>{
        val filteredList = ArrayList<LeagueResponse>()
        codeList?.forEach{
            if(
                it?.league?.id == 203
                ||it?.league?.id == 39
                ||it?.league?.id == 88
                ||it?.league?.id == 61
                ||it?.league?.id == 135
                ||it?.league?.id == 78
                ||it?.league?.id == 140){

                filteredList.add(it)
            }

        }
        return filteredList
    }
}
