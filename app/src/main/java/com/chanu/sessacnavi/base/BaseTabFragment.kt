package com.chanu.sessacnavi.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.chanu.sessacnavi.R

abstract class BaseTabFragment<VB : ViewBinding>(
    private val inflate: FragmentInflate<VB>,
) : Fragment() {
    private var _binding: VB? = null
    protected val binding get() = requireNotNull(_binding) { "ViewBinding is not initialized" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    protected abstract fun initView()

    // 공통적으로 사용할 NavController 가져오기 함수
    protected fun getParentNavController(): NavController = requireActivity().findNavController(R.id.fcv_main)

    // 공통 딥 링크 생성 함수
    protected fun createDeepLinkRequest(
        navController: NavController,
        id: String,
    ) {
        val deepLinkUri = getString(R.string.deep_link_uri).replace("{id}", id).toUri()

        val deepLinkRequest =
            NavDeepLinkRequest.Builder
                .fromUri(deepLinkUri)
                .build()

        navController.navigate(deepLinkRequest)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
