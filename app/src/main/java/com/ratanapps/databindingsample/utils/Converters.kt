package com.ratanapps.databindingsample.utils

import android.view.View
import androidx.databinding.BindingConversion

class Converters {

    @BindingConversion
    fun convertBooleanToVisibility(visible: Boolean): Int {
        if (visible)
            return View.VISIBLE
        else
            return View.INVISIBLE
    }
}