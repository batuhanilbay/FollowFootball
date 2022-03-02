package com.example.followfootball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.example.followfootball.adapter.ViewPagerAdapter
import com.example.followfootball.fragment.CountryFragment
import com.example.followfootball.fragment.LeagueFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        var viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        var tabLayout = findViewById<TabLayout>(R.id.tabLayout)



        viewPager2.adapter = adapter


        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text = "COUNTRY"
                }
                1->{
                    tab.text = "LEAGUE"
                }

            }
        }.attach()

        }
    }




/*
        val adapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){tab,position->
            when(position){
                0->{
                    tab.text = "COUNTRY"
                }
                1->{
                    tab.text = "LEAGUE"
                }

            }
        }.attach()
 */