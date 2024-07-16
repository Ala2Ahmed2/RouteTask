package com.example.productsapp.base

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.productsapp.model.ViewMessage

fun Fragment.showDialog(
    message: String,
    posActionName: String? = null,
    posActionCallBack: (() -> Unit)? = null,
    negActionName: String? = null,
    negActionCallBack: (() -> Unit)? = null,
    isCancelable: Boolean = true
): AlertDialog {
    val alertDialogBuilder = AlertDialog.Builder(requireContext())
        .setMessage(message)
        .setCancelable(isCancelable)

    if (posActionName != null) {
        alertDialogBuilder.setPositiveButton(posActionName) { dialog, _ ->
            dialog?.dismiss()
            posActionCallBack?.invoke()
        }
    }

    if (negActionName != null) {
        alertDialogBuilder.setNegativeButton(negActionName) { dialog, _ ->
            dialog?.dismiss()
            negActionCallBack?.invoke()
        }
    }

    return alertDialogBuilder.show()
}

fun Fragment.showDialog(viewMessage: ViewMessage): AlertDialog =
    showDialog(
        message = viewMessage.message,
        posActionName = viewMessage.posActionName,
        posActionCallBack = viewMessage.posAction,
        negActionName = viewMessage.negActionName,
        negActionCallBack = viewMessage.negAction,
        isCancelable = viewMessage.isDismissible
    )
