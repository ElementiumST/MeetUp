package com.example.together.data.testRetrofit.model

import com.google.android.gms.maps.model.LatLng

data class Position(
        val positionId: String,
        val lat: Double,
        val lng: Double
) {
    fun toLatLng(): LatLng {
        return LatLng(lat, lng)
    }
}
