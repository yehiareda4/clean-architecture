package com.aait.coreui.util.status_bar

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.util.Log
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.aait.coreui.R
import com.aait.coreui.util.status_bar.CompatUtils.getNavigationBarInteractionMode
import com.aait.coreui.util.status_bar.CompatUtils.getNavigationBarSize

fun Activity.setStatusBarColor(
    colorId: Int = R.color.colorBg, light: Boolean = false
) {
    setStatusBarTrans(false, light, colorId = colorId)
    val color = ContextCompat.getColor(this, colorId)
    window.statusBarColor = color
    window.navigationBarColor = color
}

@SuppressLint("ResourceAsColor")
fun Activity.setStatusBarTrans(
    fullScreen: Boolean = true,
    light: Boolean = false,
    colorId: Int = R.color.colorBg,
    hasNavBar: () -> Unit = {},
    isGestureHintEnabled: () -> Unit = {}
) {
    val color = ContextCompat.getColor(this, colorId)
    window.statusBarColor = color
    if (fullScreen) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        Log.d("NavigationBar", "setStatusBarTrans: ${getNavigationBarInteractionMode(this)}")
        if (getNavigationBarInteractionMode(this) != CompatUtils.NAVIGATION_BAR_INTERACTION_MODE_GESTURE) {
            hasNavBar()
        } else {
            if (getNavigationBarSize(this)) {
                isGestureHintEnabled()
            }
        }
    } else {
        window.clearFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        window.decorView.windowInsetsController?.setSystemBarsAppearance(
            if (light) 0 else WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
    }
}