package com.ratanapps.databindingsample.utils

import android.content.Context
import android.view.View
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.InverseBindingMethod
import androidx.databinding.InverseBindingMethods

@BindingMethods(
    BindingMethod(
        type = CustView::class,
        attribute = "text_my_color",
        method = "setTextMyColor"
    ), BindingMethod(
        type = CustView::class,
        attribute = "text_my_Size",
        method = "setTextMySize"
    ), BindingMethod(
        type = CustView::class,
        attribute = "text_my_Size",
        method = "setTextMySize"
    )
)
@InverseBindingMethods(
    InverseBindingMethod(
        type = CustView::class,
        attribute = "text_my_color",
        method = "setTextMyColor"
    ), InverseBindingMethod(
        type = CustView::class,
        attribute = "text_my_Size",
        method = "setTextMySize"
    )
)
class CustView(context:Context):View(context)
{
    fun setTextMyColor(color:Int){

    }

    fun setTextMySize(size:Int){

    }

    fun getTextMyColor():Int{
        return 0
    }

    fun getTextMySize():Int{
        return 0
    }
}