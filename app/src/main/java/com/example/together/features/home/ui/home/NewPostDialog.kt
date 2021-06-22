package com.example.together.features.home.ui.home

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.together.data.api.travels.model.Travel
import com.example.together.databinding.NewPostDialogBinding
import com.example.together.features.home.ui.map.travelabout.TravelAboutBottomFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NewPostDialog: BottomSheetDialogFragment()  {
    companion object {
        const val TAG = "NewPostDialog"
        fun newInstance(newsViewModel: NewsViewModel): NewPostDialog {
            return NewPostDialog().apply { this.newsViewModel = newsViewModel }
        }
    }
    private lateinit var binding: NewPostDialogBinding
    private lateinit var newsViewModel: NewsViewModel
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewPostDialogBinding.inflate(inflater)
        binding.button2.setOnClickListener {
            newsViewModel.createPost(binding.body.getText())
            dismiss()
        }
        return binding.root
    }
}