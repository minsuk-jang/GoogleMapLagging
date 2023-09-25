package com.example.googlemaplagging

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.googlemaplagging.base.BaseFragment
import com.example.googlemaplagging.databinding.FragmentMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main), OnMapReadyCallback {

    private lateinit var map: GoogleMap

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
            findNavController().navigate(R.id.action_main_to_main_bottom)
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
}