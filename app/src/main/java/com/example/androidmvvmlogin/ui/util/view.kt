package com.example.androidmvvmlogin.ui.util

import android.view.View

infix fun View.setVisible(isVisible: Boolean?) {
    if (isVisible == true && visibility == View.VISIBLE) {
        return
    }

    if (isVisible == false && visibility == View.GONE) {
        return
    }

    this.visibility = when (isVisible) {
        false -> View.GONE
        else -> View.VISIBLE
    }
}

//Convert trackTimeMillis = 32432455 to 2h 23m
fun formatTrackTime(millis: Int): String {
    val totalSeconds = millis / 1000
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60

    return "${hours}h ${minutes}m"
}