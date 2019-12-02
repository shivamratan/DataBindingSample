package com.ratanapps.databindingsample.ui.fragment

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.data.ModelItem
import com.ratanapps.databindingsample.databinding.ItemListFragmentBinding
import com.ratanapps.databindingsample.ui.adapter.ItemListAdapter

class ItemListFragment : Fragment() {
    private lateinit var itemLisBinding:ItemListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val itemListFragmentBinding = DataBindingUtil.inflate<ItemListFragmentBinding>(inflater,R.layout.item_list_fragment,container,false)


        val recyclerAdapter = ItemListAdapter(activity as Context,getListData())
        itemListFragmentBinding.myadapter = recyclerAdapter

        return itemListFragmentBinding.root
    }


    fun getListData() = ArrayList<ModelItem>().apply {
            add(ModelItem(modelName = "No Code Name",modelVersion = "1.0"))
            add(ModelItem("Petite Four","1.1"))
            add(ModelItem("Cupcake","1.5"))
            add(ModelItem("Donut","1.6"))
            add(ModelItem("Eclair","2.0-2.1"))
            add(ModelItem("Froyo","2.2-2.2.3"))
            add(ModelItem("GingerBread","2.3-2.3.7"))
            add(ModelItem("HoneyComb","3.0-3.2.6"))
            add(ModelItem("IceCream Sandwitch","4.0-4.0.4"))
            add(ModelItem("JellyBean","4.1-4.3.1"))
            add(ModelItem("KitKat","4.4-4.4.4"))
            add(ModelItem("LollyPop","5.1-5.1.1"))
            add(ModelItem("Marshmallow","6.0-6.0.1"))
            add(ModelItem("Noughat","7.0,7.1,7.1.1-7.1.2"))
            add(ModelItem("Oreo","8.0,8.1"))
            add(ModelItem("Pie","9.0"))
            add(ModelItem("Android 10","10.0"))
        }


    companion object{
        @BindingAdapter("adapter")
        @JvmStatic
        fun setAdapter(recyclerView: RecyclerView, adapter: ItemListAdapter){
                recyclerView.adapter = adapter
        }
    }


}
