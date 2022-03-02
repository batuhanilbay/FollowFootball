package com.example.followfootball.adapter

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.followfootball.databinding.CardDesignCountryBinding
import com.example.followfootball.model.Countries

class CountryAdapter(var mContext: Context, val countryList: List<Countries>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {




    inner class CountryViewHolder(var cardDesignCountriesBinding: CardDesignCountryBinding) : RecyclerView.ViewHolder(cardDesignCountriesBinding.root){

        fun bind(country: Countries){

            cardDesignCountriesBinding.imageViewFlag.loadImageFromUrl(country.flag)
            cardDesignCountriesBinding.textViewCountryName.text= country.name
            cardDesignCountriesBinding.textViewCountryCode.text=country.code
            cardDesignCountriesBinding.root.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.CountryViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardDesignCountryBinding.inflate(layoutInflater,parent,false)
        return CountryViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CountryAdapter.CountryViewHolder, position: Int) {

        holder.bind(countryList[position])
        //Card Gecis
        val temp = holder.cardDesignCountriesBinding
        /*temp.cardViewLine.setOnClickListener {
            val gecis = leagueDirection()
            Navigation.findNavController(it).navigate(gecis)
        }*/

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    //Coil -
    fun ImageView.loadImageFromUrl(imageUrl: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry {
                add(SvgDecoder(this@loadImageFromUrl.context))
            }
            .build()
        val imageRequest = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(300)
            .data(imageUrl)
            .target(
                onStart = {
                },
                onSuccess = { result ->
                    val bitmap = (result as BitmapDrawable).bitmap
                    this.setImageBitmap(bitmap)
                },
                onError = {
                }
            )
            .build()
        imageLoader.enqueue(imageRequest)
    }



}