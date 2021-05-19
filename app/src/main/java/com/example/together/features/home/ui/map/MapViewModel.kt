package com.example.together.features.home.ui.map

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.together.data.api.newsLine.model.Position
import com.example.together.data.api.travels.model.Travel
import io.reactivex.disposables.CompositeDisposable

class MapViewModel(
        private val compositeDisposable: CompositeDisposable,
): ViewModel() {
    val isLoadComplete = MutableLiveData<Boolean>().apply { value = false }
    val travels = MutableLiveData<List<Travel>>()
    val homeMark = MutableLiveData<Position>()

    private var isMapLoaded = false
    private var isProfileLoaded = false
    private var isTravelsLoaded = false

    fun onMapLoaded() {
        isMapLoaded = true
        updateStatus()
    }

    fun onProfileLoaded() {
        isProfileLoaded = true
        updateStatus()
    }

    fun onTravelsLoaded(travels: List<Travel>) {
        this.travels.value = travels
        isTravelsLoaded = true
        updateStatus()
    }
    fun findTravelByMarkerId(markerId: String): Travel? {
        travels.value?.forEach { travel ->
            travel.markerId?.let {
                if(markerId == travel.markerId) return travel
            }
        }
        Log.e("TESTESTEST", "find currupted")
        return null
    }

    private fun updateStatus() {
        if ( !isLoadComplete.value!! && isMapLoaded && isProfileLoaded && isTravelsLoaded) {
            isLoadComplete.value = true
        }
    }
}