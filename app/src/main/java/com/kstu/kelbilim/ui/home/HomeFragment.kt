package com.kstu.kelbilim.ui.home

import android.os.Bundle
import android.sax.Element
import android.util.Log
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.lang.Exception

class HomeFragment : Fragment(), HomeClickListener {
    private lateinit var homeAdapter: HomeAdapter
    private val listener = this
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  initViews()
        parseNews()
    }

    private fun parseNews() {
        val newsItem = ArrayList<HomeResponse>()
        val webUrl = "https://kstu.kg"
        CoroutineScope(Dispatchers.IO).launch {
            val document = Jsoup.connect(webUrl).get()
            val data: Elements? = document.select("div.grid__item")

            val dataSize = data!!.size
            for (i in 0 until dataSize) {
                val imgUrl = webUrl + data.select("img.newsbox-header-image")
                    .eq(i)
                    .attr("src")

                val title = data.select("h4.newsbox-title")
                    .eq(i)
                    .text()

                val detailUrl = webUrl + data.select("a.corner-link")
                    .eq(i)
                    .attr("href")

                newsItem.add(HomeResponse(imgUrl, title, detailUrl))
                Log.d("ITEMS", "img: $imgUrl, title: $title, detail: $detailUrl")

            }
            withContext(Dispatchers.Main) {
                homeAdapter = HomeAdapter(newsItem, listener)
                home_rv.adapter = homeAdapter
            }
        }


    }

    override fun homeItemClicked(homeResponse: HomeResponse, imageView: View) {

        val bundle = Bundle()
        bundle.putString("detailUrl", homeResponse.detailUrl)
        bundle.putString("imageUrl", homeResponse.imagePath)
        bundle.putString("title", homeResponse.title)

        findNavController().navigate(R.id.navigation_home_detail, bundle)
    }


}
