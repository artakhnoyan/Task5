package com.art.task4.presenter.photosearch

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.art.task4.R
import com.art.task4.domain.photosearch.model.State
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val photoSearchViewModel: PhotoSearchViewModel by viewModel()
    private val photoAdapter: PhotoAdapter by inject()
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = GridLayoutManager(this, 3)
        photo_list.adapter = photoAdapter
        photo_list.layoutManager = layoutManager
        photoSearchViewModel.photos.observe(this, Observer {
            photoAdapter.submitList(it)
        })
        photoSearchViewModel.requestState.observe(this, Observer {
            when (it?.state) {
                State.WAITING -> showLoading()
                State.SUCCESS -> hideLoading()
                State.FAILURE -> Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
            }
        })
        photoSearchViewModel.searchPhoto()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_photo_search, menu)
        val searchMenu = menu?.findItem(R.id.search)
        val searchView = searchMenu?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(input: String?): Boolean {
                input?.let {
                    photoSearchViewModel.searchPhoto(input)
                }
                return true
            }

            override fun onQueryTextChange(input: String?): Boolean {
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.one_column -> layoutManager.spanCount = 1
            R.id.two_column -> layoutManager.spanCount = 2
            R.id.three_column -> layoutManager.spanCount = 3
        }

        return super.onOptionsItemSelected(item)
    }

    private fun showLoading() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.abc_slide_in_bottom)
        view_loading.startAnimation(animation)
        view_loading.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.abc_slide_out_bottom)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                view_loading.visibility = View.GONE
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
        view_loading.startAnimation(animation)
    }
}
