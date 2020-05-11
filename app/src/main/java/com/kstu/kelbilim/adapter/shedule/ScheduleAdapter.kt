package com.kstu.kelbilim.adapter.shedule

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.GenericRecyclerAdapter
import com.kstu.kelbilim.common.ViewHolder
import com.kstu.kelbilim.service.response.HomeResponse
import com.kstu.kelbilim.service.response.schedule.ScheduleDiciples
import kotlinx.android.synthetic.main.item_home.view.*

class ScheduleAdapter(items: ArrayList<ScheduleDiciples> = ArrayList()) :
    GenericRecyclerAdapter<ScheduleDiciples>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_)
    }

    override fun bind(item: ScheduleDiciples, holder: ViewHolder) {
        holder.itemView.home_title.text = item.title
    }
}