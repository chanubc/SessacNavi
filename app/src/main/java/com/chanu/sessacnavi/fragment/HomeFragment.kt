package com.chanu.sessacnavi.fragment

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.chanu.sessacnavi.R
import com.chanu.sessacnavi.base.BaseFragment
import com.chanu.sessacnavi.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private lateinit var navController: NavController

    override fun initView() {
        initNavHost()
        initTabLayout()
        setTabStartFirst()
    }

    private fun initNavHost() {
        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(binding.fcvHome.id) as NavHostFragment
        navController = nestedNavHostFragment.navController
    }

    private fun initTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    when (tab.position) {
                        0 -> navController.navigate(R.id.firstFragment)
                        1 -> navController.navigate(R.id.secondFragment)
                        2 -> navController.navigate(R.id.thirdFragment)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}

                override fun onTabReselected(tab: TabLayout.Tab) {}
            },
        )
    }

    private fun setTabStartFirst() {
        binding.tabLayout.selectTab(binding.tabLayout.getTabAt(0))
        navController.navigate(R.id.firstFragment)
    }
}
