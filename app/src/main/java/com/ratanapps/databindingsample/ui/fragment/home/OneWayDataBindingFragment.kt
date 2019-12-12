package com.ratanapps.databindingsample.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.data.User
import com.ratanapps.databindingsample.databinding.FragmentHomeBinding

class OneWayDataBindingFragment : Fragment(), View.OnClickListener {

    private lateinit var homeViewModel: OneWayDBViewModel
    private lateinit var fragmentHomeBinding:FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this).get(OneWayDBViewModel::class.java)
         fragmentHomeBinding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)
        fragmentHomeBinding.viewModel = homeViewModel
        fragmentHomeBinding.handler = this

        return fragmentHomeBinding.root
    }

    override fun onClick(v: View?) {
        homeViewModel.user.value = User(name = "Shivam",profession = "Mobile",experience = "10 year")
        fragmentHomeBinding.viewModel = homeViewModel
        Toast.makeText(activity, "TextChanged !", Toast.LENGTH_LONG).show()
    }

}