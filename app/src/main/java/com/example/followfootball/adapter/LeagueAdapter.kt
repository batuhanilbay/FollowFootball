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
import com.example.followfootball.databinding.CardDesignLeagueBinding
import com.example.followfootball.model.LeagueResponse



class LeagueAdapter(var mContext: Context, val leagueList: List<LeagueResponse>): RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    var onClickListener: LeagueAdapterClickListener ?= null


    inner class LeagueViewHolder(var cardDesignLeagueBinding:  CardDesignLeagueBinding) : RecyclerView.ViewHolder(cardDesignLeagueBinding.root){

        fun bind(league: LeagueResponse){

            cardDesignLeagueBinding.imageViewLogo.loadLogo(league.league?.logo)
            cardDesignLeagueBinding.textViewLeagueName.text = league.league?.name
            cardDesignLeagueBinding.root.setOnClickListener {
                onClickListener?.onItemClick(league.league?.id!!)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueAdapter.LeagueViewHolder {

        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardDesignLeagueBinding.inflate(layoutInflater,parent,false)
        return LeagueViewHolder(tasarim)
    }

    override fun onBindViewHolder(holder: LeagueAdapter.LeagueViewHolder, position: Int) {

        holder.bind(leagueList[position])

    }



    override fun getItemCount(): Int {
        return leagueList.size
    }


    fun ImageView.loadLogo(imageUrl: String?) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry {
                add(SvgDecoder(this@loadLogo.context)) }
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

    interface LeagueAdapterClickListener {
        fun onItemClick(leagueId:Int)
    }

}





