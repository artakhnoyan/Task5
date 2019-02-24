package com.art.task4.presenter

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.art.task4.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val photoSearchViewModel: PhotoSearchViewModel by viewModel()
    private val photoAdapter: PhotoAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        photo_list.adapter = photoAdapter
        photo_list.layoutManager = GridLayoutManager(this, 3)
        photoSearchViewModel.photos.observe(this, Observer {
            photoAdapter.submitList(it)
        })
        photoSearchViewModel.searchPhoto()
    }
}
