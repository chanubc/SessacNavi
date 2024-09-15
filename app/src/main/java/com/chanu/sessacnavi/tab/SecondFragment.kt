package com.chanu.sessacnavi.tab

import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import com.chanu.sessacnavi.R
import com.chanu.sessacnavi.base.BaseFragment
import com.chanu.sessacnavi.databinding.FragmentFirstBinding

class SecondFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    override fun initView() {
        binding.tvTitle.text = getString(R.string.second)

        // 중첩 그래프 이기 때문에 최상위의 navController를 받아옴
        val parentNavController = requireActivity().findNavController(R.id.fcv_main)

        binding.btnDetail.setOnClickListener {
            val id = getString(R.string.second)
            val baseUri = getString(R.string.deep_link_uri)
            val deepLinkUri = baseUri.replace("{id}", id).toUri()

            val deepLinkRequest =
                NavDeepLinkRequest.Builder
                    .fromUri(deepLinkUri)
                    .build()

            parentNavController.navigate(deepLinkRequest)
        }
    }
}
