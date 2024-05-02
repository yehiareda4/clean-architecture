package com.aait.coreui.util.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.widget.ImageView
import com.aait.coreui.R
import com.aait.coreui.util.toGone
import com.aait.coreui.util.toVisible


fun View.handleSLideUp_down(arrow: ImageView, view: View) {

    if (view.visibility == View.GONE) {
        // Prepare the View for the animation
        view.toVisible()
        view.setAlpha(0.0f)

        // Start the animation
        view.animate()
            .translationY(0f)
            .alpha(1.0f)
            .setListener(null)
//        arrow.setImageResource(R.drawable.ic_arrow_up_blue)

    } else {
        view.animate()
            .translationY(0f)
            .alpha(0.0f)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    view.toGone()
                }
            })
//        arrow.setImageResource(R.drawable.ic_arrow_down_blue)
    }
}