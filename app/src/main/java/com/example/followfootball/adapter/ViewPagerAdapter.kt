package com.example.followfootball.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.followfootball.fragment.CountryFragment
import com.example.followfootball.fragment.LeagueFragment

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle:Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle){



    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0-> CountryFragment()

            1-> LeagueFragment()

            else->{
                Fragment()
            }
        }

    }

}