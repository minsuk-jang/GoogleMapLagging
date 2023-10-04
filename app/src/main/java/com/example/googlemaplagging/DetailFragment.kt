package com.example.googlemaplagging

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.googlemaplagging.base.BaseFragment
import com.example.googlemaplagging.databinding.FragmentDetailBinding
import com.example.googlemaplagging.extensions.logging
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

    override fun back() {
        parentFragmentManager.popBackStack()
    }
}