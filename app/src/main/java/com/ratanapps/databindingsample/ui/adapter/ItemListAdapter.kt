package com.ratanapps.databindingsample.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ratanapps.databindingsample.R
import com.ratanapps.databindingsample.data.ModelItem
import com.ratanapps.databindingsample.databinding.LayoutListItemBinding

class ItemListAdapter(val context: Context,val itemList:ArrayList<ModelItem>): RecyclerView.Adapter<ItemListAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding :LayoutListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_list_item,parent,false)
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
     return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(itemList.get(position))
    }

    class MyViewHolder(val itembinding:LayoutListItemBinding):RecyclerView.ViewHolder(itembinding.root) {
        fun bind(modelItem: ModelItem){
           itembinding.model = modelItem
           itembinding.executePendingBindings()
        }
    }
}