package com.example.googlemaplagging

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentContainer
import androidx.navigation.fragment.findNavController
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
            val id = requireActivity().findViewById<FrameLayout?>(R.id.frame_layout)?.id
                ?: return@setOnClickListener

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(id, DetailFragment.newInstance())
                addToBackStack(null)
            }.commit()
            dismiss()
        }
    }
}