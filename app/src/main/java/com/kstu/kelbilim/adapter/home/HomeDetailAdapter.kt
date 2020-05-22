package com.kstu.kelbilim.adapter.home

import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.GenericRecyclerAdapter
import com.kstu.kelbilim.common.ViewHolder
import com.kstu.kelbilim.service.response.HomeResponse
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_home_detail.view.*

class HomeDetailAdapter(
    items: ArrayList<String> = ArrayList()
) :
    GenericRecyclerAdapter<String>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_home_detail)
    }

    override fun bind(item: String, holder: ViewHolder) {
        holder.itemView.home_detail_texview.text = item
    }
}