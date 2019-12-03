package com.ratanapps.databindingsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.databinding.ActivityMainBinding
import com.ratanapps.databindingsample.ui.fragment.slideshow.MainViewModel

class MainActivity : AppCompatActivity(){


   /* lateinit var mainActivityBinding:ActivityMainBinding
   lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         mainActivityBinding = DataBindingUtil.setContentView(this,
             R.layout.activity_main
         )
         initViewModel()

         mainActivityBinding.viewModel = mainViewModel
         mainActivityBinding.handler = EventHandler()
         mainActivityBinding.listener = this@MainActivity
*/


  //  }

    /*private fun initViewModel(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onClick(v: View?) {
        Toast.makeText(v?.context,"Event Cancelled !",Toast.LENGTH_LONG).show()
    }*/




   /* class EventHandler{

        fun onCancelManipulateClick(view:View, viewModel: MainViewModel, eventHandler: EventHandler){
            Toast.makeText(view.context,viewModel.getMessage(),Toast.LENGTH_LONG).show()
        }

        fun onManipulateClick(view:View, viewModel: MainViewModel){
            Toast.makeText(view.context,viewModel.getMessage(),Toast.LENGTH_LONG).show()
        }


        fun onHandleClick(view: View){
            Log.e("EVENT_TAG","REG_SUCCESS !")
            Toast.makeText(view.context,"Registration Successful !",Toast.LENGTH_LONG).show()
        }
    }*/
}
