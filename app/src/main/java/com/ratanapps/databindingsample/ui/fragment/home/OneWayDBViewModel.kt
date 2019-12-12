package com.ratanapps.databindingsample.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ratanapps.databindingsample.data.User

class OneWayDBViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

     var user:MutableLiveData<User> = MutableLiveData()
    init {
        user.value = User("XYZ", "Engineer","2 Year")
    }


}