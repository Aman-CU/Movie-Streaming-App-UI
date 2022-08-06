package com.example.moviestreamingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var actionBar: ActionBar;
    private lateinit var bannerModelList: ArrayList<BannerModel>
    private lateinit var bannerAdapter: BannerAdapter
    private lateinit var bannerTwoAdapter: BannerTwoAdapter
    private lateinit var bannerPager: ViewPager
    private lateinit var bannerTwoPager: ViewPager

    private lateinit var castLL: LinearLayout
    private lateinit var crewLL: LinearLayout
    private lateinit var readMore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castLL = findViewById(R.id.CastLL)
        crewLL = findViewById(R.id.CrewLL)
        readMore = findViewById(R.id.readMore)


        bannerPager = findViewById(R.id.bannerPager)
        bannerTwoPager = findViewById(R.id.bannerTwoPager)

        actionBar = this.supportActionBar!!

        loadCards()
        loadCardsTwo()

        //Onclick
        readMore.setOnClickListener {

            if(castLL.isVisible && crewLL.isVisible){
                castLL.visibility = View.GONE
                crewLL.visibility = View.GONE

                readMore.text = "READ MORE"

            }else{
                castLL.visibility = View.VISIBLE
                crewLL.visibility = View.VISIBLE

                readMore.text = "READ LESS"

            }

        }



        //First Banner Pager
        bannerPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        //Second Banner Pager
        bannerTwoPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }

    private fun loadCards() {
        bannerModelList = ArrayList()

        bannerModelList.add(BannerModel(R.drawable.thornew))
        bannerModelList.add(BannerModel(R.drawable.avengersnew))
        bannerModelList.add(BannerModel(R.drawable.spidermannew))
        bannerModelList.add(BannerModel(R.drawable.shanshinew))

        bannerAdapter = BannerAdapter(this,bannerModelList)
        bannerPager.adapter = bannerAdapter
        bannerPager.setPadding(5,0,200,0)


    }

    private fun loadCardsTwo(){
        bannerModelList = ArrayList()

        bannerModelList.add(BannerModel(R.drawable.ironmaniw))
        bannerModelList.add(BannerModel(R.drawable.spierderman))
        bannerModelList.add(BannerModel(R.drawable.deadpoolmovieposter))
        bannerModelList.add(BannerModel(R.drawable.avengersiw))

        bannerTwoAdapter = BannerTwoAdapter(this,bannerModelList)
        bannerTwoPager.adapter = bannerTwoAdapter
        bannerTwoPager.setPadding(5,0,320,0)
    }
}