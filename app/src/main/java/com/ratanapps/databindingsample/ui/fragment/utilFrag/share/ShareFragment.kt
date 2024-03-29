package com.ratanapps.databindingsample.ui.fragment.utilFrag.share

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.databinding.FragmentShareBinding


class ShareFragment : Fragment() {

    private lateinit var shareViewModel: ShareViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shareViewModel = ViewModelProviders.of(this).get(ShareViewModel::class.java)
        val fragmentShareBinding:FragmentShareBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_share, container, false)
        fragmentShareBinding.viewmOdel = shareViewModel





        return fragmentShareBinding.root
    }


companion object {

    @BindingAdapter("android:onClick", "android:clickable", requireAll = false)
    @JvmStatic
    fun setOnClick(view: View, clickListener: View.OnClickListener, clickable: Boolean) {
        view.setOnClickListener(clickListener)
        view.isClickable = clickable
    }

}

    inner class CustomView(context:Context) : View(context) {
        fun setTextColor(color: Int) {

        }
    }
}