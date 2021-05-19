package com.example.together.features.home.ui.map.travelabout

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.together.data.api.travels.model.Travel
import com.example.together.databinding.TravelAboutBottomFragmentBinding
import com.example.together.features.tags.TagsAdapter
import com.example.together.features.views.post.PostView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager


class TravelAboutBottomFragment: BottomSheetDialogFragment() {
    companion object {
        const val TAG = "TravelAboutBottomFragment"
        fun newInstance(travel: Travel): TravelAboutBottomFragment {
            return TravelAboutBottomFragment().apply {
                this.travel = travel
            }
        }
    }
    private lateinit var travel: Travel
    private lateinit var binding: TravelAboutBottomFragmentBinding


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener { setupBottomSheet(it) }
        return dialog
    }

    private fun setupBottomSheet(dialogInterface: DialogInterface) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        val bottomSheet = bottomSheetDialog.findViewById<View>(
                com.google.android.material.R.id.design_bottom_sheet)
                ?: return
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = TravelAboutBottomFragmentBinding.inflate(inflater)
        prepareTopPreviewImage()
        prepareImageList()
        prepareTextDataOfTravel()
        preparePostHolder()
        prepareTags()
        return binding.root
    }

    private fun prepareTags() {
        binding.tagList.layoutManager =
            FlowLayoutManager()
                .apply { isAutoMeasureEnabled = true }
        binding.tagList.adapter =
            TagsAdapter(travel.tags!!)
    }

    private fun preparePostHolder() {
        binding.postContainer
                .addView(
                        PostView(
                                post = travel.post!!,
                                context = requireContext(),
                                null
                        )
                )
    }

    private fun prepareTextDataOfTravel() {
        binding.title.text = travel.name
        binding.dateOfCreate.text = travel.dateOfStart
    }

    private fun prepareImageList() {
        if(travel.images?.size == 1) {
            binding.recyclerView.visibility = View.INVISIBLE
            return
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context).apply { orientation = RecyclerView.HORIZONTAL }
        binding.recyclerView.adapter = TravelImagesAdapter(travel.images!!.drop(1))

    }

    private fun prepareTopPreviewImage() {
        if(travel.images.isNullOrEmpty()) {
            binding.posterImage.visibility = View.INVISIBLE
            return
        }
        Glide.with(this)
                .load(travel.images!![0])
                .into(binding.posterImage)
    }


}