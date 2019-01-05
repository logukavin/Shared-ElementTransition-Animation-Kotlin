package com.example.orgware.transition_animation_kotlin.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Url(

	@field:SerializedName("small")
	val small: String? = null,

	@field:SerializedName("large")
	val large: String? = null,

	@field:SerializedName("medium")
	val medium: String? = null
):Serializable