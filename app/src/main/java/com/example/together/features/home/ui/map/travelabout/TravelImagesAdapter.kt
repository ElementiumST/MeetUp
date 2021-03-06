package com.example.together.features.home.ui.map.travelabout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.together.R
import com.example.together.databinding.ItemTravelImagesBinding

class TravelImagesAdapter(
        private val imageLinks: List<String>
): RecyclerView.Adapter<TravelImagesAdapter.TravelImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelImageViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_travel_images, parent, false)
        return TravelImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: TravelImageViewHolder, position: Int) {
        holder.bind(imageLinks[position])
    }

    override fun getItemCount(): Int {
        return imageLinks.size
    }

    private fun openViewer(
        startPosition: Int,
        target: ImageView,
        images: List<String>,
        imageViews: List<ImageView>) {
//        viewer = StfalconImageViewer.Builder<String>(this, images, ::loadImage)
//            .withStartPosition(startPosition)
//            .withTransitionFrom(target)
//            .withImageChangeListener { viewer.updateTransitionImage(imageViews.getOrNull(it)) }
//            .show()
    }

    inner class TravelImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val binding: ItemTravelImagesBinding = ItemTravelImagesBinding.bind(itemView)
        fun bind(imageLink: String) {
            Glide.with(itemView)
                    .load(imageLink)
                    .into(binding.image)
        }
    }
}