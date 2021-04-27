package com.example.together.features.views.auth

import android.annotation.SuppressLint
import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import androidx.annotation.StyleRes
import androidx.appcompat.widget.AppCompatButton
import com.example.together.R


@SuppressLint("CustomViewStyleable")
class TwoColorNonAccentButton(context: Context, attrs: AttributeSet?): AppCompatButton(context, attrs) {
    private var firstText: String = ""
    private var secondaryText: String = ""
    init {
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.TwoColorTextHolder,
            0,
            0
        )
        isAllCaps = false
        try {
            firstText = typedArray.getString(R.styleable.TwoColorTextHolder_firstText)?: ""
            secondaryText = typedArray.getString(R.styleable.TwoColorTextHolder_secondText)?: ""
        } finally {
            typedArray.recycle()
        }
        setBackgroundColor(
            resources.getColor(
                R.color.background,
                context.theme
            )
        )
        setTextColor(
            resources.getColor(
                R.color.accent,
                context.theme
            )
        )
        text = SpannableString("$firstText $secondaryText").apply {
            setSpan(
                ForegroundColorSpan(resources.getColor(
                    R.color.gray_400,
                    context.theme)),
                0,
                firstText.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

    }
}