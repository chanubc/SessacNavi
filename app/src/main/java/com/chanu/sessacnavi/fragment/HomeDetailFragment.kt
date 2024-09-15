package com.chanu.sessacnavi.fragment

import androidx.navigation.fragment.navArgs
import com.chanu.sessacnavi.base.BaseFragment
import com.chanu.sessacnavi.databinding.FragmentHomeDetailBinding

class HomeDetailFragment : BaseFragment<FragmentHomeDetailBinding>(FragmentHomeDetailBinding::inflate) {
    override fun initView() {
        val args: HomeDetailFragmentArgs by navArgs()
        if (args.id.isNotEmpty()) binding.tvDetailTitle.text = args.id
    }
}
