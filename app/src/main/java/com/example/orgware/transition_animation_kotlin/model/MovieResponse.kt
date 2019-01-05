package com.example.orgware.transition_animation_kotlin.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResponse(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: Url? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
):Serializable