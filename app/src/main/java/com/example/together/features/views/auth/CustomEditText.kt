package com.example.together.features.views.auth

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.together.R
import com.example.together.databinding.CustomEditTextBinding
class CustomEditText: FrameLayout {

    lateinit var binding: CustomEditTextBinding
    private var alertText: String = ""
    private var title: String = ""
    private var inputType: Int = -1

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


    fun pushAlert(alertMessage: String){
        binding.alertText.text = alertMessage
    }
    private fun hookAttributes(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(
                attrs,
                R.styleable.CustomEditText,
                0,
                0
        )
        try {
            alertText = typedArray.getString(R.styleable.CustomEditText_alertText)?: ""
            title = typedArray.getString(R.styleable.CustomEditText_title)?: ""
            inputType = typedArray.getInt(R.styleable.CustomEditText_android_inputType, -1)
        } finally {
            typedArray.recycle()
        }
    }
    private fun init() {
        binding = CustomEditTextBinding.inflate(LayoutInflater.from(context))
        addView(binding.root)
        binding.alertText.text = alertText
        binding.title.text = title
        binding.editText.inputType = inputType
    }

}

