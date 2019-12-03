package com.ratanapps.databindingsample.ui.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.databinding.FragmentSendBinding
import com.ratanapps.databindingsample.ui.ui.share.ShareFragment
import com.ratanapps.databindingsample.ui.ui.slideshow.SlideshowFragment
import com.ratanapps.databindingsample.ui.ui.tools.ToolsFragment

class SendFragment : Fragment() {

    private lateinit var sendViewModel: SendViewModel
    private lateinit var fragmentSendBinding:FragmentSendBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        sendViewModel =
            ViewModelProviders.of(this).get(SendViewModel::class.java)
        fragmentSendBinding = DataBindingUtil.inflate<FragmentSendBinding>(inflater,R.layout.fragment_send,container,false)

        return fragmentSendBinding.root
    }


    class PagerAdapter(fm:FragmentManager): FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int)= when(position){
                0-> ShareFragment()
                1-> SlideshowFragment()
                2-> ToolsFragment()
                else -> ShareFragment()
            }


        override fun getCount() = 3

        override fun getPageTitle(position: Int) = when(position){
            0 -> "Share"
            1 -> "Slide"
            2 -> "Tools"
            else -> "Default"
        }


    }


    companion object{
        @BindingAdapter("currentTab")
        @JvmStatic
        fun setTab(viewPager: ViewPager, itemLiveData: MutableLiveData<Int>){
            itemLiveData.value.let {
                if(viewPager.currentItem != itemLiveData.value){
                    viewPager.setCurrentItem(itemLiveData.value?:0, true)
                }
            }
        }


        @InverseBindingAdapter(attribute = "currentTab", event = "currentTabAttrChanged")
        @JvmStatic
        fun getTab(pager:ViewPager)  = pager.currentItem
    }
}