package com.example.together.features.views.profile

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.example.together.R
import com.example.together.databinding.ViewRoundedImageBinding

class RoundedProfileImage : CardView {
    private var image = 0
    private lateinit var imageView: ImageView
    private var height: Float = 0f;
    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        hookAttributes(attrs)
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        hookAttributes(attrs)
        init()
    }

    fun setImage(link: String) {
        Glide.with(this)
            .load(link)
            .placeholder(resources.getDrawable(R.drawable.ic_baseline_person_24, context.theme))
            .into(binding.imageView)
    }

    val binding = ViewRoundedImageBinding.inflate(LayoutInflater.from(context))
    private fun hookAttributes(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.RoundedProfileImage,
            0,
            0
        )
        try {
            image = typedArray.getResourceId(R.styleable.RoundedProfileImage_image, 0)
        } finally {
            typedArray.recycle()
        }
    }
    private fun init() {
        addView(binding.root)
        setContentPadding(10, 10, 10, 10)


    }

}
