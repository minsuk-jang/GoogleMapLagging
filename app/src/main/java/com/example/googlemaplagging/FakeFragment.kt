package com.example.googlemaplagging

import android.os.Bundle
import android.view.View
import com.example.googlemaplagging.base.BaseFragment
import com.example.googlemaplagging.databinding.FragmentMainBottomSheetDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FakeFragment :
    BaseFragment<FragmentMainBottomSheetDialogBinding>(R.layout.fragment_main_bottom_sheet_dialog) {
    companion object {
        fun newInstance(): FakeFragment {
            return FakeFragment().apply {

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindButton()
    }

    private fun bindButton() {
        binding.buttonMoveDetail.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
                replace(R.id.frame_layout, DetailFragment.newInstance())
                addToBackStack(null)
                postponeEnterTransition()
            }.commit()
        }
    }
}