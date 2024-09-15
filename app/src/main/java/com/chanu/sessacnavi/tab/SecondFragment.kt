package com.chanu.sessacnavi.tab

import com.chanu.sessacnavi.R
import com.chanu.sessacnavi.base.BaseTabFragment
import com.chanu.sessacnavi.databinding.FragmentFirstBinding

class SecondFragment : BaseTabFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    override fun initView() {
        binding.tvTitle.text = getString(R.string.second)
        binding.btnDetail.setOnClickListener {
            createDeepLinkRequest(getParentNavController(), getString(R.string.second))
        }
    }
}
