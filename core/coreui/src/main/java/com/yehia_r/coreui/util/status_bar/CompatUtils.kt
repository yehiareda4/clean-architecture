package com.aait.coreui.util.status_bar

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.util.Log
import android.view.Display
import android.view.WindowManager
import java.lang.reflect.InvocationTargetException


object CompatUtils {
    /**
     * Classic three-button navigation (Back, Home, Recent Apps)
     */
    const val NAVIGATION_BAR_INTERACTION_MODE_THREE_BUTTON = 0

    /**
     * Two-button navigation (Android P navigation mode: Back, combined Home and Recent Apps)
     */
    const val NAVIGATION_BAR_INTERACTION_MODE_TWO_BUTTON = 1

    /**
     * Full screen gesture mode (introduced with Android Q)
     */
    const val NAVIGATION_BAR_INTERACTION_MODE_GESTURE = 2

    /**
     * Returns the interaction mode of the system navigation bar as defined by
     * [NavigationBarInteractionMode]. Depending on the Android version and OEM implementation,
     * users might change the interaction mode via system settings: System>Gestures>System Navigation.
     * This can lead to conflicts with apps that use specific system-gestures internally for
     * navigation (i. e. swiping), especially if the Android 10 full screen gesture mode is enabled.
     *
     *
     * Before Android P the system has used a classic three button navigation. Starting with Android P
     * a two-button-based interaction mode was introduced (also referred as Android P navigation).
     *
     *
     * Android Q changed the interaction and navigation concept to a gesture approach, the so called
     * full screen gesture mode: system-wide gestures are used to navigate within an app or to
     * interact with the system (i. e. back-navigation, open the home-screen, changing apps, or toggle
     * a fullscreen mode).
     *
     *
     * Based on [
 * https://stackoverflow.com/questions/56689210/how-to-detect-full-screen-gesture-mode-in-android-10](https://stackoverflow.com/questions/56689210/how-to-detect-full-screen-gesture-mode-in-android-10)
     *
     * @param context The [Context] that is used to read the resource configuration.
     * @return the [NavigationBarInteractionMode]
     * @see .NAVIGATION_BAR_INTERACTION_MODE_THREE_BUTTON
     *
     * @see .NAVIGATION_BAR_INTERACTION_MODE_TWO_BUTTON
     *
     * @see .NAVIGATION_BAR_INTERACTION_MODE_GESTURE
     */
    fun getNavigationBarInteractionMode(context: Context): Int {
        val resources = context.resources
        val resourceId =
            resources.getIdentifier("config_navBarInteractionMode", "integer", "android")

        return if (resourceId > 0) resources.getInteger(resourceId) else NAVIGATION_BAR_INTERACTION_MODE_THREE_BUTTON
    }

    fun getNavigationBarSize(context: Context): Boolean {
        val appUsableSize = getAppUsableScreenSize(context)
        val realScreenSize = getRealScreenSize(context)

        // navigation bar on the right
        if (appUsableSize.x < realScreenSize.x) {
            return false
        }


        Log.d("NavigationBar", "appUsableSize: $appUsableSize")
        Log.d("NavigationBar", "realScreenSize: $realScreenSize")
        // navigation bar at the bottom
        return if (appUsableSize.y < realScreenSize.y) {
            val point = Point(appUsableSize.x, realScreenSize.y - appUsableSize.y)
            point.y > 80
        } else false

        // navigation bar is not present
    }

    private fun getAppUsableScreenSize(context: Context): Point {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size
    }

    private fun getRealScreenSize(context: Context): Point {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        if (Build.VERSION.SDK_INT >= 17) {
            display.getRealSize(size)
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                size.x = (Display::class.java.getMethod("getRawWidth").invoke(display) as Int)
                size.y = (Display::class.java.getMethod("getRawHeight").invoke(display) as Int)
            } catch (e: IllegalAccessException) {
            } catch (e: InvocationTargetException) {
            } catch (e: NoSuchMethodException) {
            }
        }
        return size
    }


}
