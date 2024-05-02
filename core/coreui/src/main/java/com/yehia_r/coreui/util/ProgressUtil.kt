package com.aait.coreui.util

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import com.aait.coreui.R
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ProgressUtil @Inject constructor(val context: Activity) {


    private var dialog: AlertDialog? = null


    init {
        init()
    }


    private fun init() {
        dialog = AlertDialog.Builder(context).create()
        val inflate = LayoutInflater.from(context).inflate(R.layout.progress, null)
        dialog?.setView(inflate)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)

        if (dialog?.window != null) {
            dialog?.window!!
                .setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            dialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }


    fun showProgress() {
        if (dialog != null && dialog?.isShowing == false) {
            dialog?.show()
        }
    }


    fun hideProgress() {
        if (dialog?.isShowing == true) {
            dialog?.cancel()
            dialog?.hide()
        }
    }

    fun isLoading(): Boolean = dialog?.isShowing == true

}
