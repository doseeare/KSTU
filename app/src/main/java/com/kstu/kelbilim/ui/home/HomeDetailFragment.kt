package com.kstu.kelbilim.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kstu.kelbilim.R
import com.kstu.kelbilim.adapter.home.HomeDetailAdapter
import com.kstu.kelbilim.adapter.viewpager.ImageVPAdapter
import com.kstu.kelbilim.utils.MyUtils
import kotlinx.android.synthetic.main.fragment_home_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.select.Elements

class HomeDetailFragment : Fragment() {
    private var detailUrl = ""
    private var title = ""
    private val images = ArrayList<String>()
    private val contents = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArguments()
        parseNews()
    }

    private fun initArguments() {
        detailUrl = try {
            arguments?.getString("detailUrl")
        } catch (e: Exception) {

        } as String
        title = try {
            arguments?.getString("title")
        } catch (e: Exception) {

        } as String
    }


    private fun parseNews() {
        if (!MyUtils.isInternetAvailable()) {
            val webUrl = "https://kstu.kg"

            CoroutineScope(Dispatchers.IO).launch {

                val document = Jsoup.connect(detailUrl).get()
                val imageData: Elements? = document.select("div.news-img-wrap")
                val contentData: Elements? = document.select("div.small-12.columns.in-text")

                // imagePath on website and count of imges
                val imagePath = imageData!!.select("div.outer")
                    .select("div.mediaelement.mediaelement-image")
                    .select("a")
                val imageCount = imagePath.size

                // contentPath on website and count of text content on the page
                val contentPath = contentData!!
                    .select("div")
                    .select("p")
                val contentCount = contentPath.size

                for (i in 0 until imageCount) {
                    val imgUrl = webUrl + imagePath
                        .eq(i)
                        .attr("href")
                    images.add(imgUrl)
                }

                for (i in 0 until contentCount) {
                    val contentText = contentPath
                        .eq(i)
                        .text()
                    if(contentText.isNotEmpty()){
                        contents.add(contentText)
                    }
                }

                val postDate =
                    document.select("span.news-list-date")
                        .select("time")
                        .attr("datetime")

                withContext(Dispatchers.Main) {
                    home_detail_vp.adapter = ImageVPAdapter(requireContext(), images)
                    home_detail_title.text = title
                    home_detail_rv.adapter = HomeDetailAdapter(contents)
                    home_detail_date.text = postDate.replace('-', '.')

                    Log.d("homeDetail", "postDate: $postDate, img: $images, contents: $contents")
                }
            }
        } else {

        }
    }

}
