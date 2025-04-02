package com.sergiocrespotoubes.ui.components

import android.content.Context
import android.widget.Toast
import com.sergiocrespotoubes.ui.R

fun showToastError(context: Context) {
    Toast.makeText(
        context,
        context.getString(R.string.splash_error_message),
        Toast.LENGTH_LONG,
    ).show()
}
