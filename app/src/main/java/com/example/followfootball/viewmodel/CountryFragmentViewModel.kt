package com.example.followfootball.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.followfootball.model.Countries
import com.example.followfootball.model.CountryResponse
import com.example.followfootball.retrofit.Api
import com.example.followfootball.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CountryFragmentViewModel:ViewModel() {

    fun downloadCountry(){
        allGetCountry()
    }

    var countriesList: MutableLiveData<List<Countries>> = MutableLiveData()
    val countryDaoInterface = Api.getDaoInterface()

    fun allGetCountry(){

        countryDaoInterface.allCountries(RetrofitClient.API_KEY, Api.BASE_URL).enqueue(object :
            Callback<CountryResponse> {
            override fun onResponse(call: Call<CountryResponse>?,
                                    countryResponse: Response<CountryResponse>?) {

                val liste = countryResponse?.body()?.response
                liste?.apply {
                    var filteredData = filteredCodeData(liste)
                    countriesList.postValue(filteredData)
                }

            }

            override fun onFailure(call: Call<CountryResponse>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })

    }

    //Filtering Country
    fun filteredCodeData(codeList: List<Countries>): ArrayList<Countries> {
        val filteredList = ArrayList<Countries>()
        codeList.forEach{
            if  (it.name=="Turkey"
                || it.name=="England"
                || it.name=="Netherlands"
                || it.name=="France"
                || it.name=="Italy"
                || it.name=="Germany"
                || it.name=="Spain"){

                filteredList.add(it)

            }

        }
        return filteredList

    }

}