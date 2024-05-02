package com.aait.coreui.util

import android.app.Activity
import com.aait.coreui.R
import com.pd.chocobar.ChocoBar
import com.example.awesomedialog.*

fun Activity.showToast(
    message: String?,
    toastType: ToastType = ToastType.ERROR,
) {
    if (message.isNullOrEmpty()) return
    when (toastType) {
        ToastType.SUCCESS -> {
            ChocoBar.builder()
                .setActivity(this)
                .setText(message)
                .setDuration(ChocoBar.LENGTH_SHORT)
//                .setActionText(getString(R.string.text_ok))
                .green()
                .show()
//            Toasty.success(this, message, Toast.LENGTH_SHORT, withIcon).show()
        }

        ToastType.ERROR -> {
            ChocoBar.builder()
                .setActivity(this)
                .setText(message)
                .setDuration(ChocoBar.LENGTH_SHORT)
//                .setActionText(getString(R.string.text_ok))
                .red()
                .show()
//            Toasty.error(this, message, Toast.LENGTH_SHORT, withIcon).show()
        }

        ToastType.INFO -> {
            ChocoBar.builder()
                .setActivity(this)
                .setText(message)
                .setDuration(ChocoBar.LENGTH_SHORT)
                .orange()
                .show()
//            Toasty.info(this, message, Toast.LENGTH_SHORT, withIcon).show()
        }

        ToastType.WARNING -> {
            ChocoBar.builder()
                .setActivity(this)
                .setText(message)
                .setDuration(ChocoBar.LENGTH_SHORT)
                .infoGray()
                .show()
//            Toasty.warning(this, message, Toast.LENGTH_SHORT, withIcon).show()
        }
    }
}

fun Activity.createDialog(
    title: String, msg: String,
    positiveTitle: String,
    positive: (dialog: androidx.appcompat.app.AlertDialog) -> Unit,
    negativeTitle: String? = null,
    negative: (dialog: androidx.appcompat.app.AlertDialog) -> Unit? = { }
) {
    val awesomeDialog = AwesomeDialog.build(this)
    awesomeDialog.title(title)
        .body(msg)
        .onPositive(positiveTitle) {
            positive(awesomeDialog)
        }
        .setCancelable(false)
    if (!negativeTitle.isNullOrEmpty()) {
        awesomeDialog.onNegative(negativeTitle) {
            negative(awesomeDialog)
        }
    }
}

enum class ToastType {
    SUCCESS, ERROR, WARNING, INFO
}
