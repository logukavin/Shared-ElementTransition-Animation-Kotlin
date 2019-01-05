package com.example.orgware.transition_animation_kotlin.ui.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.orgware.transition_animation_kotlin.R
import com.example.orgware.transition_animation_kotlin.model.MovieResponse
import kotlinx.android.synthetic.main.item_list.view.*


class ListAdapter(var context: Context, val clickmanager: ClickManager) :
    RecyclerView.Adapter<ListAdapter.ContactHolder>() {
    var movieResponse: List<MovieResponse>? = null

    init {
        movieResponse = ArrayList()
    }

    fun setFolderList(item: ArrayList<MovieResponse>? = null) {
        if (item == null)
            return
        movieResponse = item
        notifyDataSetChanged()

    }

    interface ClickManager {
        fun onItemClick(movieResponse: MovieResponse, textView: TextView, imageView: ImageView)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ContactHolder {
        return ContactHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int {
        return movieResponse!!.size
    }

    override fun onBindViewHolder(holder: ListAdapter.ContactHolder, position: Int) {
        holder.bindData(movieResponse!![position])
    }

    inner class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var v: View = view

        fun bindData(item: MovieResponse) {
            v.txtName.text = item.name
            Glide.with(context)
                .load(item.url!!.large)
                .into(v.ivDetail)
            v.container.setOnClickListener { v ->
                val position = adapterPosition
                if (position < 0) {
                    return@setOnClickListener
                }
                if (clickmanager != null) {
                    clickmanager.onItemClick(movieResponse!![position], v.txtName,v.ivDetail)
                }
            }
        }

    }

}


