package com.example.orgware.transition_animation_kotlin.ui.home

import com.example.orgware.kotlinapicall.utils.RxJavaUtils
import com.example.orgware.transition_animation_kotlin.app.AppController
import com.example.orgware.transition_animation_kotlin.base.AbstractBasePresenter
import com.example.orgware.transition_animation_kotlin.model.MovieResponse
import rx.functions.Action1

class MainPresenter : AbstractBasePresenter<MainView>() {

    private var mainView: MainView? = null


    override fun setView(view: MainView) {
        mainView = view
        appRepo = AppController.getInstanse()!!.getappRepo()
    }

    fun movie() {
        mainView!!.showLoading()
        appRepo!!.getContact()
            .compose(RxJavaUtils.applyObserverSchedulers())
            .subscribe(Action1<List<MovieResponse>> { movieResponse: List<MovieResponse> ->
                    if (mainView != null)
                        mainView!!.onSuccess(movieResponse)
                    mainView!!.hideLoading()

                }, Action1<Throwable> { throwable: Throwable? ->
                    mainView!!.showError(throwable!!.message!!)
                    mainView!!.hideLoading()
                })
    }


}