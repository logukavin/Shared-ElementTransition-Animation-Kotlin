package com.example.orgware.transition_animation_kotlin.app

import com.example.orgware.transition_animation_kotlin.model.MovieResponse
import retrofit2.http.GET
import rx.Observable


interface ApiInterface {

    @GET("json/glide.json")
    fun getSampleApi(): Observable<List<MovieResponse>>


}