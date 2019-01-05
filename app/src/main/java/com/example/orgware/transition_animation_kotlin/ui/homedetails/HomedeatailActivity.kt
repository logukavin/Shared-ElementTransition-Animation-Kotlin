package com.example.orgware.transition_animation_kotlin.ui.homedetails

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.Transition
import com.bumptech.glide.Glide
import com.example.orgware.transition_animation_kotlin.R
import com.example.orgware.transition_animation_kotlin.R.id.ivDetail
import com.example.orgware.transition_animation_kotlin.base.BaseActivity
import com.example.orgware.transition_animation_kotlin.model.MovieResponse
import kotlinx.android.synthetic.main.activity_details.*

class HomedeatailActivity : BaseActivity() {

    companion object {
        val DATA = "DATA"
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_details)

        val item = intent.extras.get(DATA) as MovieResponse

        txtName.text = item.name
        Glide.with(this)
            .load(item.url!!.large)
            .into(ivDetail)
        window.sharedElementEnterTransition.addListener(object : Transition.TransitionListener {
            override fun onTransitionEnd(transition: Transition?) {
                Glide.with(this@HomedeatailActivity)
                    .load(item.url.large)
                    .into(ivDetail)
            }

            override fun onTransitionResume(transition: Transition?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTransitionPause(transition: Transition?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTransitionCancel(transition: Transition?) {
                //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTransitionStart(transition: Transition?) {
                //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
