package com.example.googlemaplagging

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import com.example.googlemaplagging.base.BaseFragment
import com.example.googlemaplagging.databinding.FragmentMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private var isFirst: Boolean = true

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment().apply {
                arguments = bundleOf()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindMapFragment()
        bindButton()
    }

    private fun bindMapFragment() {
        val supportFragment =
            childFragmentManager.findFragmentById(R.id.fragment_map) as? SupportMapFragment

        supportFragment?.getMapAsync(this)
    }

    private fun bindButton() {
        binding.buttonMoveDetail.setOnClickListener {
            /*parentFragmentManager.beginTransaction().apply {
                replace(R.id.frame_layout, DetailFragment.newInstance())
                addToBackStack(null)
            }.commit()*/

            val dialog = MainBottomSheetDialogFragment()
            dialog.show(parentFragmentManager, "tag")
        }
    }

    override fun onMapReady(p0: GoogleMap) {
        map = p0

        val sydney = LatLng(-34.0, 151.0)
        map.addMarker(MarkerOptions().apply {
            position(sydney)
                .title("Marker is Sydney")
        })

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f))
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView: ")
    }
}