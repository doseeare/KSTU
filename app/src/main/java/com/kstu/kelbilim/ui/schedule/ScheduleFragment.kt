package com.kstu.kelbilim.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.viewpager.FragmentVPAdapter
import com.kstu.kelbilim.common.RetrofitHeader
import com.kstu.kelbilim.service.AppPreferences
import com.kstu.kelbilim.service.Status
import com.kstu.kelbilim.service.model.Authen
import com.kstu.kelbilim.service.model.UserInfoModel
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ScheduleFragment : Fragment() {
    private val viewModel: ScheduleViewModel by viewModel()
    private val header = RetrofitHeader()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewModel.getSchedule(
            header.header("97"),
            UserInfoModel(AppPreferences.studentId!!.toInt(), Authen())
        ).observe(viewLifecycleOwner, Observer { result ->
                val data = result.data
                val msg = result.msg
                when (result.status) {
                    Status.SUCCESS -> {
                        val adapter = FragmentVPAdapter(childFragmentManager)
                        data!!.weekDays.forEachIndexed { index, it ->
                            adapter.addFragment(
                                ScheduleWeeksFragment(it.scheduleDiciples),
                                data.weekDays[index].weekDayShortName
                            )
                        }
                        schedule_vp.adapter = adapter
                        schedule_tabs!!.setupWithViewPager(schedule_vp)
                    }
                    Status.ERROR -> {
                        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
                    }
                    Status.NETWORK -> {
                        Toast.makeText(context, "Проблемы с интернетом", Toast.LENGTH_LONG)
                            .show()
                    }
                    else -> {
                        Toast.makeText(context, "Произошла ошибка", Toast.LENGTH_LONG).show()
                    }
                }
            })
    }
}
