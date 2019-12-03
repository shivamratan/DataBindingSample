package com.ratanapps.databindingsample.ui.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.PagerAdapter
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
        fragmentSendBinding.myadapter = PagerAdapter(requireActivity().supportFragmentManager)
        fragmentSendBinding.viewModel = sendViewModel
        fragmentSendBinding.tabLayout.setupWithViewPager(fragmentSendBinding.viewPager)



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

        @BindingAdapter("viewPagerAdapter")
        @JvmStatic
        fun setAdapter(viewPager: ViewPager, pagerAdapter: PagerAdapter){
            viewPager.adapter = pagerAdapter
        }

        @BindingAdapter("currentTab")
        @JvmStatic
        fun setCurrentTab(viewPager: ViewPager, itemLiveData: MutableLiveData<Int>){
            itemLiveData.value.let {
                if(viewPager.currentItem != itemLiveData.value){
                   if(itemLiveData.value == 2)
                       viewPager.setCurrentItem(0,true)
                   else
                    viewPager.setCurrentItem(itemLiveData.value?:0, true)
                }else{
                    if(itemLiveData.value == 2)
                        viewPager.setCurrentItem(0,true)
                }
            }
        }


        @BindingAdapter("currentTabAttrChanged")
        @JvmStatic
        fun setCurrentTabListener(viewPager:ViewPager, listener:InverseBindingListener){
            viewPager.addOnPageChangeListener(object:ViewPager.SimpleOnPageChangeListener(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    listener.onChange()
                }
            })
        }


        @InverseBindingAdapter(attribute = "currentTab", event = "currentTabAttrChanged")
        @JvmStatic
        fun getCurrentTab(pager:ViewPager)  = pager.currentItem
    }
}