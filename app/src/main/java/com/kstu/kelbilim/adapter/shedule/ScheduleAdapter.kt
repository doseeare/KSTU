package com.kstu.kelbilim.adapter.shedule

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kstu.kelbilim.R
import com.kstu.kelbilim.common.GenericRecyclerAdapter
import com.kstu.kelbilim.common.ViewHolder
import com.kstu.kelbilim.service.response.schedule.ScheduleDiciples
import kotlinx.android.synthetic.main.item_schedule.view.*

class ScheduleAdapter(items: ArrayList<ScheduleDiciples> = ArrayList()) :
    GenericRecyclerAdapter<ScheduleDiciples>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return super.onCreateViewHolder(parent, R.layout.item_schedule)
    }

    override fun bind(item: ScheduleDiciples, holder: ViewHolder) {
        val view = holder.itemView

        view.schedule_auditory.text = item.auditoriaNumber
        view.schedule_name.text = item.name
        view.schedule_lesson_type.text = item.studyTypeName
        view.schedule_teacher.text = item.teacherName
        view.schedule_time.text = item.time

    }
}