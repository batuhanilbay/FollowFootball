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
import com.example.followfootball.databinding.FragmentCountryBinding
import com.example.followfootball.viewmodel.CountryFragmentViewModel


class CountryFragment : Fragment() {

    private lateinit var binding:FragmentCountryBinding
    private lateinit var adapter:CountryAdapter
    private lateinit var viewModel:CountryFragmentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_country,container,false)

        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        observeLiveData()


    }

    private fun init(){
        val tempViewModel : CountryFragmentViewModel by viewModels()
        this.viewModel = tempViewModel

        binding.countryFragment = this

        viewModel.downloadCountry()
    }

    private fun observeLiveData(){

        viewModel.countriesList.observe(viewLifecycleOwner) { cList ->

            adapter = CountryAdapter(binding.root.context, cList)

            binding.rvCountry.adapter = adapter

        }

    }



}