package com.kstu.kelbilim.adapter.home

import android.view.View
import com.kstu.kelbilim.service.response.HomeResponse

interface HomeClickListener {
    fun homeItemClicked(homeResponse: HomeResponse, imageView: View)
}