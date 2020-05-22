package com.kstu.kelbilim.ui.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.schedule.ScheduleAdapter
import com.kstu.kelbilim.adapter.schedule.ScheduleItemListener
import com.kstu.kelbilim.service.response.schedule.ScheduleDiciples
import kotlinx.android.synthetic.main.fragment_schedule_weeks.*

/**
 * A simple [Fragment] subclass.
 */
class ScheduleWeeksFragment(list : List<ScheduleDiciples>) : Fragment(), ScheduleItemListener {

    private val item = list
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule_weeks, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        schedule_rv.adapter = ScheduleAdapter(item as ArrayList<ScheduleDiciples>, this)
    }

    override fun scheduleItemClicked(model: ScheduleDiciples) {
        ScheduleDialogFragment(model).show(childFragmentManager, "ScheduleBottomFragment")
    }
}
