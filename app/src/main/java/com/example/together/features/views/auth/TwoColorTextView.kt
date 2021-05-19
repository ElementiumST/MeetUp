package com.example.together.features.views.auth

import android.annotation.SuppressLint
import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import com.example.together.R

@SuppressLint("CustomViewStyleable")
class TwoColorTextView(context: Context, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatTextView(context, attrs) {

    private var firstText: String
    private var secondaryText: String
    private val isReverse: Boolean

    init {
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.TwoColorTextHolder,
            0,
            0
        )
        try {
            isReverse = typedArray.getBoolean(R.styleable.TwoColorTextHolder_reverse, false)

            firstText = typedArray.getString(R.styleable.TwoColorTextHolder_firstText)?: ""
            secondaryText = typedArray.getString(R.styleable.TwoColorTextHolder_secondText)?: ""

        } finally {
            typedArray.recycle()
        }
        updateText()
    }
    fun setFirstText(s: String) {
        firstText = s;
        updateText()
    }
    fun setSecondText(s: String) {
        secondaryText = s;
        updateText()
    }

    private fun updateText() {
        if (isReverse) {
            setTextColor(
                    resources.getColor(
                            R.color.gray_400,
                            context.theme
                    )
            )
            text = SpannableString("$firstText $secondaryText").apply {
                setSpan(
                        ForegroundColorSpan(resources.getColor(
                                R.color.gray_200,
                                context.theme)),
                        0,
                        firstText.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }
        } else {
            setTextColor(
                    resources.getColor(
                            R.color.gray_200,
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

}