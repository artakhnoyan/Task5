package com.art.task4.presenter.photosearch

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.art.task4.R
import com.art.task4.domain.photosearch.model.PhotoData
import com.art.task4.presenter.PhotoLoader

class PhotoAdapter(
    private val photoLoader: PhotoLoader
) : PagedListAdapter<PhotoData, PhotoAdapter.PhotoViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(container.context)
                .inflate(R.layout.item_photo, container, false)

        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        photo?.let {
            photoLoader.loadPhoto(holder.image, photo.link)
        }
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<PhotoData>() {
            override fun areItemsTheSame(
                oldPhotoData: PhotoData,
                newPhotoData: PhotoData
            ): Boolean = oldPhotoData.id == newPhotoData.id

            override fun areContentsTheSame(
                oldPhotoData: PhotoData,
                newPhotoData: PhotoData
            ): Boolean =
                oldPhotoData == newPhotoData
        }
    }
}
