package com.kstu.kelbilim.adapter

import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.GenericRecyclerAdapter
import com.kstu.kelbilim.common.ViewHolder
import com.kstu.kelbilim.service.response.HomeResponse
import com.kstu.kelbilim.service.response.ProfileResponse
import kotlinx.android.synthetic.main.item_home.view.*

class ProfileAdapter(
    items: ArrayList<ProfileResponse> = ArrayList()
) :
    GenericRecyclerAdapter<ProfileResponse>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_profile)
    }

    override fun bind(item: ProfileResponse, holder: ViewHolder) {

    }
}