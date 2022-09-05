package com.leb.sunflower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.leb.sunflower.adapters.MY_GARDEN_PAGE_INDEX
import com.leb.sunflower.adapters.PLANT_LIST_PAGE_INDEX
import com.leb.sunflower.adapters.SunflowerPagerAdapter
import com.leb.sunflower.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding:ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(mainBinding.root);
        val tabLayout = mainBinding.tabLayout;
        val viewPager = mainBinding.homeViewPager;

        viewPager.adapter = SunflowerPagerAdapter(this);

        //Set the icon and text for each tab (??)
        TabLayoutMediator(tabLayout,viewPager){ tab,position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach();
    }
    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> R.drawable.garden_tab_selector
            PLANT_LIST_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> getString(R.string.my_garden_title)
            PLANT_LIST_PAGE_INDEX -> getString(R.string.plant_list_title)
            else -> null
        }
    }

}