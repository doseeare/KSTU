package com.kstu.kelbilim.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kstu.kelbilim.R
import com.kstu.kelbilim.service.response.schedule.ScheduleDiciples
import kotlinx.android.synthetic.main.fragment_schedule_dialog.*

class ScheduleDialogFragment(disciplines: ScheduleDiciples) : BottomSheetDialogFragment() {
    private val item = disciplines
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        schedule_bs_name.text = item.name
        schedule_bs_time.text = item.time
        schedule_bs_online.text = item.teacherName
        schedule_bs_auditory.text = getAuditory(item.auditoriaNumber)
        when (item.studyTypeName) {
            "Пр." -> schedule_bs_type.text = "Практика"
            "Лк.." -> schedule_bs_type.text = "Лекция"
            else -> schedule_bs_type.text = item.studyTypeName
        }
    }


    private fun getAuditory(text: String): String {
        return if (text.length == 4) {
            schedule_bs_imageview.setImageResource(R.drawable.image_1c)
            "Корпус: колледж, аудитория: ${text.substring(2, 4)}"

        } else {
            schedule_bs_imageview.setImageResource(R.drawable.image_2c)
            "Корпус: ${text.substring(0, 1)}, аудитория: ${text.substring(2, 5)}"
        }
    }

}
