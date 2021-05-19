package com.example.together.data.api.travels

import com.example.together.data.api.travels.model.Travel
import io.reactivex.Single

interface TravelsRepository {
    fun getMapTravels(): Single<List<Travel>>
}