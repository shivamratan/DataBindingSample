package com.ratanapps.databindingsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ratanapps.databindingsample.databinding.ActivityMainBinding
import com.ratanapps.databindingsample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

   lateinit var mainActivityBinding:ActivityMainBinding
   lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         mainActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
         initViewModel()

        mainActivityBinding.viewModel = mainViewModel



    }

    private fun initViewModel(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
}
