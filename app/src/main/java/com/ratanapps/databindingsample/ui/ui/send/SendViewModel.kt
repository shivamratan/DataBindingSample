package com.ratanapps.databindingsample.ui.ui.send

import androidx.databinding.InverseBindingListener
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SendViewModel : ViewModel() {

    val currentTab:MutableLiveData<Int> = MutableLiveData()
    val inverseBindingListener:InverseBindingListener= object :InverseBindingListener{
        override fun onChange() {

        }

    }

    init {
        currentTab.value = 1
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is send Fragment"
    }
    val text: LiveData<String> = _text
}