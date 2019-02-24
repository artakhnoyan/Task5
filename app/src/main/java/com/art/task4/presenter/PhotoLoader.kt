package com.art.task4.presenter

import android.app.Application
import android.widget.ImageView
import com.bumptech.glide.Glide

class PhotoLoader(application: Application) {
    private val loader = Glide.with(application.applicationContext)

    fun loadPhoto(imageView: ImageView, url: String) {
        loader.load(url).into(imageView)
    }
}
