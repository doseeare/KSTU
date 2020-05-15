package com.kstu.kelbilim.adapter.profile

import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.GenericRecyclerAdapter
import com.kstu.kelbilim.common.ViewHolder
import com.kstu.kelbilim.service.response.HomeResponse
import kotlinx.android.synthetic.main.item_home.view.*

class HomeAdapter(
    items: ArrayList<HomeResponse> = ArrayList()
) :
    GenericRecyclerAdapter<HomeResponse>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_home)
    }

    override fun bind(item: HomeResponse, holder: ViewHolder) {
        

    }
}