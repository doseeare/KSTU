package com.kstu.kelbilim.ui.schedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.viewpager.FragmentVPAdapter
import kotlinx.android.synthetic.main.fragment_schedule.*

/**
 * A simple [Fragment] subclass.
 */
class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager(schedule_vp)
        schedule_tabs!!.setupWithViewPager(schedule_vp)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = FragmentVPAdapter(childFragmentManager)
        adapter.addFragment(ScheduleWeeksFragment(0), "Пн")
        adapter.addFragment(ScheduleWeeksFragment(1), "Вт")
        adapter.addFragment(ScheduleWeeksFragment(2), "Ср")
        adapter.addFragment(ScheduleWeeksFragment(3), "Чт")
        adapter.addFragment(ScheduleWeeksFragment(4), "Пт")
        adapter.addFragment(ScheduleWeeksFragment(5), "Сб")
        viewPager.adapter = adapter
    }
}
