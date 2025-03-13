package com.dd.personalwallet.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingItemDecoration(private val spacingHorizontal: Int, private val spacingVertical: Int)
    : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        if (position != itemCount - 1) {
            outRect.bottom = spacingVertical
            outRect.right = spacingHorizontal
        }
    }
}
