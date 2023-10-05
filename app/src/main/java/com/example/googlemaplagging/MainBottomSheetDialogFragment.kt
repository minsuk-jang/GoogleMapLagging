package com.example.googlemaplagging

import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

    }

    private fun bindButton() {
        binding.buttonMoveDetail.setOnClickListener {
            /*parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout,DetailFragment.newInstance())
                addToBackStack(null)
            }.commit()*/
            Log.e(TAG, "Before: ${requireActivity().supportFragmentManager.fragments} ")
            dismiss()

            val supportFm = requireActivity().supportFragmentManager
            Handler(Looper.getMainLooper()).post {
                Log.e(TAG, "After: ${supportFm.fragments}")

                supportFm.beginTransaction().apply {
                    replace(R.id.frame_layout, DetailFragment.newInstance())
                    addToBackStack(null)
                }.commit()
            }
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