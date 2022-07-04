package com.rk.riggle_sales.utils.event

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.constraintlayout.motion.widget.MotionLayout

class ClickableMotionLayout : MotionLayout {

    val obrTouch = SingleLiveEvent<Int>()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            obrTouch.value = MotionEvent.ACTION_DOWN
        } else if (event?.action == MotionEvent.ACTION_UP) {
            obrTouch.value = MotionEvent.ACTION_UP
        }
        return super.onTouchEvent(event)
    }

}