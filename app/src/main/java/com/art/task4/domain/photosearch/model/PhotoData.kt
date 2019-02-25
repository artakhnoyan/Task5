package com.art.task4.domain.photosearch.model

data class PhotoData(val id: Long, private val url: String) {
	val link
		get() = "$url?c256x256"
}