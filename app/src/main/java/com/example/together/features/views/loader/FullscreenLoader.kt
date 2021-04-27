package com.example.together.features.views.loader

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.together.databinding.FullscreenLoadViewBinding

class FullscreenLoader(context: Context, attrs: AttributeSet?): FrameLayout(context, attrs) {
    val binding = FullscreenLoadViewBinding.inflate(LayoutInflater.from(context))
    init {
        addView(binding.root)
    }
}