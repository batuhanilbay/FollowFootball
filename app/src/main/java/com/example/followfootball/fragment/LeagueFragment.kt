package com.example.followfootball.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.followfootball.R
import com.example.followfootball.adapter.CountryAdapter
import com.example.followfootball.adapter.LeagueAdapter
import com.example.followfootball.databinding.FragmentLeagueBinding
import com.example.followfootball.viewmodel.CountryFragmentViewModel
import com.example.followfootball.viewmodel.LeagueFragmentViewModel


class LeagueFragment : Fragment() {

    private lateinit var binding : FragmentLeagueBinding
    private lateinit var adapter : LeagueAdapter
    private lateinit var viewModel: LeagueFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_league,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        observeLiveData()
    }

    private fun init(){
        val tempViewModel : LeagueFragmentViewModel by viewModels()
        this.viewModel = tempViewModel

        binding.leagueFragment = this

        viewModel.downloadLeague()
    }

    private fun observeLiveData(){

        viewModel.leagueList.observe(viewLifecycleOwner) { cList ->

            adapter = LeagueAdapter(binding.root.context, cList)

            binding.rvLeague.adapter = adapter

        }

    }


}