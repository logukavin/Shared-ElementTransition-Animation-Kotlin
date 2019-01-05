package com.example.orgware.transition_animation_kotlin.ui.home

import com.example.orgware.transition_animation_kotlin.base.LoadDataView
import com.example.orgware.transition_animation_kotlin.model.MovieResponse


interface MainView: LoadDataView {
    fun onSuccess(movieResponse: List<MovieResponse>) {

    }
}