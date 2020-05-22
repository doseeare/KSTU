package com.kstu.kelbilim.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.home.HomeAdapter
import com.kstu.kelbilim.service.response.HomeResponse
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class HomeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
   //     initViews()
    }

  /*  private fun parseNews() {
        val newsItem = ArrayList<HomeResponse>()
        val webUrl = "https://kstu.kg"
        CoroutineScope(Dispatchers.IO).launch {
            val document = Jsoup.connect(webUrl).get()
            val data : Elements? = document.select("div.grid__item")

            val dataSize = data!!.size
            for (i in 0 until dataSize){
                val imgUrl = webUrl + data.select("img.newsbox-header-image")
                    .eq(i)
                    .attr("src")

                val title = data.select("h4.newsbox-title")
                    .eq(i)
                    .text()
                newsItem.add(HomeResponse(imgUrl, title))
                Log.d("ITEMS","img: $imgUrl, title: $title")

            }
            withContext(Dispatchers.Main){
                homeAdapter = HomeAdapter(newsItem, listener)
                home_rv.adapter = homeAdapter
            }
        }


    }*/


    private fun initViews() {
        val newsItem = ArrayList<HomeResponse>()
        val webUrl = "https://kstu.kg"
    }

}
