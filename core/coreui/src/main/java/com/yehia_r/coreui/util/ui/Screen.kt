package com.aait.coreui.util.ui

import android.content.Context
import android.graphics.Insets
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.WindowMetrics


fun Context.getScreenWidth(): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val windowMetrics: WindowMetrics =
            (this.getSystemService(Context.WINDOW_SERVICE) as WindowManager).currentWindowMetrics
        val insets: Insets = windowMetrics.windowInsets
            .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
        windowMetrics.bounds.width() - insets.left - insets.right
    } else {
        val displayMetrics = DisplayMetrics()
        (this.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
            .getMetrics(displayMetrics)
        displayMetrics.widthPixels
    }
}

fun View.splitScreen(screenWidth: Int, nu: Double) {
    val itemWidth = screenWidth / nu

    val lp = this.layoutParams
    lp.height = lp.height
    lp.width = itemWidth.toInt()
    this.layoutParams = lp

}