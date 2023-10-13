package com.example.googlemaplagging

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.googlemaplagging.base.BaseBottomSheetDialogFragment
import com.example.googlemaplagging.databinding.FragmentMainBottomSheetDialogBinding
import com.example.googlemaplagging.extensions.logging
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class MainBottomSheetDialogFragment :
    BaseBottomSheetDialogFragment<FragmentMainBottomSheetDialogBinding>(R.layout.fragment_main_bottom_sheet_dialog) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindButton()

        logging("Dialog")
    }

    private fun bindButton() {
        binding.buttonMoveDetail.setOnClickListener {
            dismiss()

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout, DetailFragment.newInstance())
                addToBackStack(null)
            }.commit()
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        Log.e(TAG, "onDismiss: ")
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Log.e(TAG, "onCancel: ")
    }
}