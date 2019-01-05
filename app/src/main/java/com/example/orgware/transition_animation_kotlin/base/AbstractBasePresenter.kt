package com.example.orgware.transition_animation_kotlin.base

import com.example.orgware.transition_animation_kotlin.app.AppRepo


open class AbstractBasePresenter<in V : BaseView> : BasePresenter<V> {


    private var view: V? = null
    protected var appRepo: AppRepo? = null

    override fun setView(view: V) {
        this.view = view

    }

    override fun destroyView() {
        view = null

    }

    override fun destroy() {
        destroyView()
    }

}
