package com.leb.sunflower.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.leb.sunflower.GardenFragment
import com.leb.sunflower.PlantListFragment

const val MY_GARDEN_PAGE_INDEX = 0;
const val PLANT_LIST_PAGE_INDEX = 1;

class SunflowerPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val tabFragmentCreators: Map<Int, () -> Fragment> = mapOf(
        MY_GARDEN_PAGE_INDEX to { GardenFragment() },
        PLANT_LIST_PAGE_INDEX to { PlantListFragment() }
    )

    override fun getItemCount(): Int {
        return tabFragmentCreators.size;
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}