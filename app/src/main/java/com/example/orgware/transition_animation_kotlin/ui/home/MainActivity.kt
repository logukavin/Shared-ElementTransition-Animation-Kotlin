package com.example.orgware.transition_animation_kotlin.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.orgware.transition_animation_kotlin.R
import com.example.orgware.transition_animation_kotlin.base.BaseActivity
import com.example.orgware.transition_animation_kotlin.model.MovieResponse
import com.example.orgware.transition_animation_kotlin.ui.homedetails.HomedeatailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView, ListAdapter.ClickManager {
    private var mainPresenter = MainPresenter()
    private var listAdapter: ListAdapter? = null


    override fun onCreate(savedInstance: Bundle?) {
        super.onCreate(savedInstance)
        setContentView(R.layout.activity_main);
        mainPresenter.setView(this)
        mainPresenter.movie()


        rv_list.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter(this, this)
        rv_list.adapter = listAdapter
    }

    override fun onSuccess(movieResponse: List<MovieResponse>) {
        listAdapter!!.setFolderList(movieResponse as ArrayList<MovieResponse>)
    }

    override fun hideLoading() {
    }

    override fun showError(message: String) {
        Toast.makeText(this@MainActivity, "Error: " + message, Toast.LENGTH_SHORT).show()
        Log.d("TAG", "Error :" + message)
    }

    override fun context(): Context {
        return this

    }

    override fun onItemClick(movieResponse: MovieResponse, textView: TextView, imageView: ImageView) {
        val detailIntent = Intent(this, HomedeatailActivity::class.java)
        val imageViewPair = Pair.create<View, String>(imageView, getString(R.string.image_transition_name))
        val textViewPair = Pair.create<View, String>(textView, getString(R.string.text_transition_name))
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imageViewPair, textViewPair)
        detailIntent.putExtra(HomedeatailActivity.DATA, movieResponse)
        startActivity(detailIntent, options.toBundle())


    }

    override fun showLoading() {

    }
}



