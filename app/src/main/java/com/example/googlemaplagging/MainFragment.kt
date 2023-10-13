package com.example.googlemaplagging

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import com.example.googlemaplagging.base.BaseFragment
import com.example.googlemaplagging.databinding.FragmentMainBinding
import com.example.googlemaplagging.extensions.logging
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMapOptions
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(savedInstanceState != null)
            Log.e(TAG, "Main is Recreated!! ")

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //bindMapFragment()
        bindButton()

        logging("main")
    }

    private fun bindMapFragment() {
        val supportFragment =
            childFragmentManager.findFragmentById(R.id.fragment_map) as? SupportMapFragment
        supportFragment?.getMapAsync(this)
    }

    private fun bindButton() {
        binding.buttonMoveDetail.setOnClickListener {
            /*parentFragmentManager.beginTransaction().apply {
                add(R.id.frame_layout, FakeFragment.newInstance())
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
}