package com.ratanapps.databindingsample.ui.fragment.slideshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.databinding.ActivityMainBinding

class SlideshowFragment : Fragment(),View.OnClickListener {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainActivityBinding = DataBindingUtil.inflate<ActivityMainBinding>(inflater,R.layout.activity_main, container, false)

        initViewModel()

        mainActivityBinding.viewModel = mainViewModel
        mainActivityBinding.handler = EventHandler()
        mainActivityBinding.listener = this

        return mainActivityBinding.root
    }


    private fun initViewModel(){
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onClick(v: View?) {
        Toast.makeText(v?.context,"Event Cancelled !", Toast.LENGTH_LONG).show()
    }




    class EventHandler{

        fun onCancelManipulateClick(view:View, viewModel: MainViewModel, eventHandler: EventHandler){
            Toast.makeText(view.context,viewModel.getMessage(), Toast.LENGTH_LONG).show()
        }

        fun onManipulateClick(view:View, viewModel: MainViewModel){
            Toast.makeText(view.context,viewModel.getMessage(), Toast.LENGTH_LONG).show()
        }


        fun onHandleClick(view: View){
            Log.e("EVENT_TAG","REG_SUCCESS !")
            Toast.makeText(view.context,"Registration Successful !", Toast.LENGTH_LONG).show()
        }
    }
}