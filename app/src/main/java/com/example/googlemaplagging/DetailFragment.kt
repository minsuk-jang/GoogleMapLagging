package com.example.googlemaplagging

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.googlemaplagging.base.BaseFragment
import com.example.googlemaplagging.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {
    companion object {
        fun newInstance(): DetailFragment {
            return DetailFragment().apply {
                arguments = bundleOf()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}