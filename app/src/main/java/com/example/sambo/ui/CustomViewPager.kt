package com.example.sambo.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager : ViewPager {
    private var PageForCustomView = false

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return PageForCustomView && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return PageForCustomView && super.onInterceptTouchEvent(event)
    }

    fun setPageScrollEnabled(isPageScrollEnabled: Boolean) {
        this.PageForCustomView = isPageScrollEnabled
    }
}