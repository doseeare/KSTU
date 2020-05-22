package com.kstu.kelbilim.adapter.viewpager

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.kstu.kelbilim.R

class ImageVPAdapter(private val context: Context, private val imageUrls: ArrayList<String>) :
    PagerAdapter() {

    override fun getCount(): Int {
        return imageUrls.size
    }

    override fun isViewFromObject(@NonNull view: View, @NonNull `object`: Any): Boolean {
        return view === `object`
    }

    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {

        val imageView = ImageView(context)
        try {
            Glide.with(imageView)
                .load(imageUrls[position])
                .thumbnail(Glide.with(imageView).load(R.drawable.ic_animeted_placeholder))
                .centerCrop()
                .into(imageView)
            container.addView(imageView)

        } catch (e: Exception) {
        }
        return imageView
    }

    override fun destroyItem(@NonNull container: ViewGroup, position: Int, @NonNull `object`: Any) {
        container.removeView(`object` as View)
    }

}