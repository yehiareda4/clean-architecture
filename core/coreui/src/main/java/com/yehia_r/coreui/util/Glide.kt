package com.aait.coreui.util

import android.content.Context
import android.widget.ImageView
import com.aait.coreui.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadImageFromUrl(url: String?) {
    Glide.with(this.context)
        .load(url)
        .error(R.drawable.shape_btn)
        .into(this)
}

fun ImageView.loadImageFromUrlWithResize(url: String?,height:Int = 200,width:Int = 200) {
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions().override(width, height))
        .error(R.drawable.shape_btn)
        .into(this)
}

fun ImageView.loadCircleImageFromUrl(url: String?,height:Int = 200,width:Int = 200) {
    Glide.with(this.context)
        .load(url)
        .apply(RequestOptions().override(width, height).circleCrop())
        .error(R.drawable.shape_btn)
        .into(this)
}

fun ImageView.loadImageFromDrawable(context: Context, url: Int) {
    Glide.with(context)
        .load(url)
        .into(this)
}