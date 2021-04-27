package com.example.together.features.home.ui.map

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.together.R
import com.example.together.data.testRetrofit.model.Position
import com.example.together.data.testRetrofit.travels.model.Travel
import com.example.together.databinding.FragmentMapsBinding
import com.example.together.features.home.HomeActivity
import com.example.together.features.home.ui.map.travelabout.TravelAboutBottomFragment
import com.example.together.features.utils.App
import com.example.together.features.utils.bitmapDescriptorFromVector
import com.example.together.features.utils.mapStyle
import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import javax.inject.Inject

class MapsFragment : Fragment() {

    companion object {
        const val TAG = "MapsFragment"
    }
    @Inject
    lateinit var mapViewModelFactory: MapViewModelFactory

    private val viewModel: MapViewModel by viewModels { mapViewModelFactory }

    private lateinit var binding: FragmentMapsBinding

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initDagger()
        binding = FragmentMapsBinding.inflate(inflater)
        attachHomeViewModel()
        viewModel.isLoadComplete.observe(viewLifecycleOwner) { if (it) loadSuccessCallback() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        viewModel.onTravelsLoaded(listOf())
        mapFragment.getMapAsync(callback)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun loadSuccessCallback() {
        val homeMarkerOptions = MarkerOptions().apply {
            viewModel.homeMark.value?.toLatLng()?.let {
                position(it)
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(it, 14.0f))
            }
            icon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_home_map_24dp))
            title(resources.getString(R.string.home))
            draggable(false)
        }
        googleMap.addMarker(homeMarkerOptions)
        subscribeOnTravels()
        setListeners()

    }

    private fun setListeners() {
        googleMap.setOnMarkerClickListener {
            viewModel.findTravelByMarkerId(it.id)?.let {
                it1 -> hideTraverAboutFragment(it1)
            }
            return@setOnMarkerClickListener false
        }
    }

    private fun hideTraverAboutFragment(travel: Travel) {
        TravelAboutBottomFragment
                .newInstance(travel)
                .show(childFragmentManager, tag)
    }

    private fun subscribeOnTravels() {
        viewModel.travels.observe(viewLifecycleOwner) {
            for (travel in it) {
                createMarkerForTravel(travel)
            }
        }
    }

    private fun attachHomeViewModel() {
        (activity as HomeActivity).viewModel.apply {
            profile.observe(viewLifecycleOwner) {
                viewModel.onProfileLoaded()
                viewModel.homeMark.value = it.homePosition
            }
            travels.observe(viewLifecycleOwner) {
                viewModel.travels.value = it
            }
        }

    }

    private fun createMarkerForTravel(travel: Travel) {
        val markerOptions = MarkerOptions().apply {
            travel.position?.toLatLng()?.let { position(it) }
            icon(bitmapDescriptorFromVector(requireContext(), R.drawable.ic_baseline_place_map_24))
            title(travel.name)
            draggable(false)
        }
        googleMap.addMarker(markerOptions)
                .also { travel.markerId = it.id }
    }

    private val callback = OnMapReadyCallback { googleMap ->
        this.googleMap = googleMap
        googleMap.setMinZoomPreference(10f)
        googleMap.setMapStyle(MapStyleOptions(mapStyle))
        viewModel.onMapLoaded()
    }

    private fun initDagger() {
        DaggerMapComponent
                .builder()
                .appComponent(App.appComponent)
                .build()
                .inject(this)
    }
}