package com.example.orgware.transition_animation_kotlin.base

interface BasePresenter<in V : BaseView> {
    fun setView(view: V)

    fun destroyView()

    fun destroy()
}