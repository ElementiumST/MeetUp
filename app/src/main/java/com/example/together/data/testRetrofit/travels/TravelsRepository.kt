package com.example.together.data.testRetrofit.travels

import com.example.together.data.testRetrofit.travels.model.Travel
import io.reactivex.Single

interface TravelsRepository {
    fun getMapTravels(): Single<List<Travel>>
}