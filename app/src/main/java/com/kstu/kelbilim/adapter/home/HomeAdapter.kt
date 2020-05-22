package com.kstu.kelbilim.adapter.home

import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.GenericRecyclerAdapter
import com.kstu.kelbilim.common.ViewHolder
import com.kstu.kelbilim.service.response.HomeResponse
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(
    items: ArrayList<HomeResponse> = ArrayList(), private val listener: HomeClickListener
) :
    GenericRecyclerAdapter<HomeResponse>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_home)
    }

    override fun bind(item: HomeResponse, holder: ViewHolder) {
        holder.itemView.home_title.text = item.title

        Glide.with(holder.itemView)
            .load(item.imagePath)
            .placeholder(R.drawable.ic_animeted_placeholder)
            .into(holder.itemView.home_imageview)

        holder.itemView.setOnClickListener {
            listener.homeItemClicked(item, holder.itemView.home_imageview)
        }
    }
}