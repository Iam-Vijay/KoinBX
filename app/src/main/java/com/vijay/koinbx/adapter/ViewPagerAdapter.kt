package com.vijay.koinbx.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vijay.koinbx.ui.home.slidefragments.GainersFragment
import com.vijay.koinbx.ui.home.slidefragments.LooserFragment
import com.vijay.koinbx.ui.home.slidefragments.NewCurrencyFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = listOf(
        NewCurrencyFragment(),
        GainersFragment(),
        LooserFragment()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}