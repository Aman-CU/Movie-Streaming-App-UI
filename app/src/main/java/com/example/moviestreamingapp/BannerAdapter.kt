package com.example.moviestreamingapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter

class BannerAdapter(private val context: Context, private val BannerModelArrayList: ArrayList<BannerModel>): PagerAdapter() {
    override fun getCount(): Int {
        return  BannerModelArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(context).inflate(R.layout.card_item, container,false)


        val model = BannerModelArrayList[position]
        val image = model.image

        val bannerTop = view.findViewById(R.id.banner_top) as ImageView
        bannerTop.setImageResource(image)

        view.setOnClickListener {
            Log.d("Clicked","Hi")
        }

        container.addView(view,position)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object`as View)
    }
}