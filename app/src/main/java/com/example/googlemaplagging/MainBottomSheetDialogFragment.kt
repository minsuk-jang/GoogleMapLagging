package com.example.googlemaplagging

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.googlemaplagging.base.BaseBottomSheetDialogFragment
import com.example.googlemaplagging.databinding.FragmentMainBottomSheetDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainBottomSheetDialogFragment :
    BaseBottomSheetDialogFragment<FragmentMainBottomSheetDialogBinding>(R.layout.fragment_main_bottom_sheet_dialog) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindButton()

    }

    private fun bindButton() {
        binding.buttonMoveDetail.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout, DetailFragment.newInstance())
                addToBackStack(null)
            }.commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }
}