package com.kstu.kelbilim.adapter.profile

import Payments
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.GenericRecyclerAdapter
import com.kstu.kelbilim.common.ViewHolder
import com.kstu.kelbilim.service.response.HomeResponse
import kotlinx.android.synthetic.main.item_home.view.*
import kotlinx.android.synthetic.main.item_profile.view.*

class ProfileAdapter(
    items: ArrayList<Payments> = ArrayList()
) :
    GenericRecyclerAdapter<Payments>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_profile)
    }

    override fun bind(item: Payments, holder: ViewHolder) {
        val precent = item.contract / (item.paid / 100)
        val view = holder.itemView
        view.profile_course.text = item.kurs
        view.profile_debt.text = "Долг: ${item.dolg.toInt()}"
        view.profile_contract.text = "Контракт: ${item.contract.toInt()}"
        view.profile_pay.text = "Долг: ${item.paid.toInt()}"
        view.profile_precent.text = "$precent%"
    }
}