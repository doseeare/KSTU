package com.kstu.kelbilim.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.home.HomeAdapter
import com.kstu.kelbilim.adapter.home.HomeClickListener
import com.kstu.kelbilim.service.response.HomeResponse
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeClickListener {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        val item = arrayListOf(
            HomeResponse("", "", "Для преподавателей проходят онлайн-курсы повышения квалификации", ""),
            HomeResponse("", "", "Для преподавателей проходят онлайн-курсы повышения квалификации", ""),
            HomeResponse("", "", "Для преподавателей проходят онлайн-курсы повышения квалификации", ""),
            HomeResponse("", "", "Для преподавателей проходят онлайн-курсы повышения квалификации", ""),
            HomeResponse("", "", "Для преподавателей проходят онлайн-курсы повышения квалификации", ""),
            HomeResponse("", "", "Для преподавателей проходят онлайн-курсы повышения квалификации", ""),
            HomeResponse("", "", "Для преподавателей проходят онлайн-курсы повышения квалификации", ""),
            HomeResponse("", "", "Для преподавателей проходят онлайн-курсы повышения квалификации", "")
        )
        home_rv.adapter = HomeAdapter(item, this)
    }

    override fun homeItemClicked(homeResponse: HomeResponse, imageView: View) {
        findNavController().navigate(R.id.navigation_home_detail)
    }


}
