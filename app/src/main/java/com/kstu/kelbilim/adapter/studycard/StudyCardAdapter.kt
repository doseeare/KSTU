package com.kstu.kelbilim.adapter.studycard

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.GenericRecyclerAdapter
import com.kstu.kelbilim.common.ViewHolder
import com.kstu.kelbilim.service.response.studycard.CardDiciplines
import com.timelysoft.shelter.utils.MyUtils
import kotlinx.android.synthetic.main.item_card.view.*

class StudyCardAdapter(
    items: ArrayList<CardDiciplines> = ArrayList()
) :
    GenericRecyclerAdapter<CardDiciplines>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_card)
    }

    override fun bind(item: CardDiciplines, holder: ViewHolder) {
        val view = holder.itemView

        when (item.ball) {
            0 -> {
                view.card_cardview.setCardBackgroundColor(Color.parseColor("#868686"))
                view.card_status.text = "Не сдан"
            }
            in 0..40 -> {
                view.card_cardview.setCardBackgroundColor(Color.parseColor("#F2453D"))
                view.card_status.text = "Незачет"
            }
            in 41..60 -> {
                view.card_cardview.setCardBackgroundColor(Color.parseColor("#ECA461"))
                view.card_status.text = "FX"
            }
            in 61..74 -> {
                view.card_cardview.setCardBackgroundColor(Color.parseColor("#E37F23"))
                view.card_status.text = "Удов"
            }
            in 74..87 -> {
                view.card_cardview.setCardBackgroundColor(Color.parseColor("#19B84F"))
                view.card_status.text = "Хорошо"
            }
            in 87..100 -> {
                view.card_cardview.setCardBackgroundColor(Color.parseColor("#1E56E8"))
                view.card_status.text = "Отлично"
            }
        }

        view.card_date.text = MyUtils.toMyDate(item.deliveryDate)
        view.card_name.text = item.name
        view.card_point.text = "Баллы: ${item.ball}"
        view.card_credit.text = "Долги: ${item.credit}"
    }
}