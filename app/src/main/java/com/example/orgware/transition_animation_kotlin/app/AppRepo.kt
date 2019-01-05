package com.example.orgware.transition_animation_kotlin.app

import com.example.orgware.kotlinapicall.utils.RxJavaUtils
import com.example.orgware.transition_animation_kotlin.model.MovieResponse
import rx.Observable


class AppRepo(appApi: ApiInterface) {

    private var appApi: ApiInterface


    init {
        this.appApi = appApi
    }

    fun getContact(): Observable<List<MovieResponse>> {
        return appApi.getSampleApi().compose(RxJavaUtils.applyErrorTransformer())
                .map {it}
    }




}