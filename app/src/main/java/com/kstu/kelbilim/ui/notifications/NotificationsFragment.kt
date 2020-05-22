package com.kstu.kelbilim.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.viewpager.FragmentVPAdapter
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val vpAdapter = FragmentVPAdapter(childFragmentManager)
        vpAdapter.addFragment(NotificationPoints(), "Уведомления")
        vpAdapter.addFragment(NotificationChannel(), "Входящие")
        notification_vp.adapter = vpAdapter
        notification_tabs.setupWithViewPager(notification_vp)
    }

}
