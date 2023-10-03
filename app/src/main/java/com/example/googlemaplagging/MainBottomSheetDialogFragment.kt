package com.example.googlemaplagging

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.findNavController
import com.example.googlemaplagging.base.BaseBottomSheetDialogFragment
import com.example.googlemaplagging.databinding.FragmentMainBottomSheetDialogBinding
import com.example.googlemaplagging.extensions.logging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainBottomSheetDialogFragment :
    BaseBottomSheetDialogFragment<FragmentMainBottomSheetDialogBinding>(R.layout.fragment_main_bottom_sheet_dialog) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindButton()

        logging(name = "Dialog")
    }

    private fun bindButton() {
        binding.buttonMoveDetail.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_map, DetailFragment.newInstance())
                addToBackStack(null)
            }.commit()

            dismiss()
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