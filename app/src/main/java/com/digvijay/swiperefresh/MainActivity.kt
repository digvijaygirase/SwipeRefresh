package com.digvijay.swiperefresh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.digvijay.swiperefresh.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.swipe.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener { loadImage() })

        loadImage()
    }

    fun loadImage() {

        val random = (1..100).random()

        val url = "https://randomuser.me/api/portraits/women/$random.jpg"

        Picasso.get().load(url)
            .fit()
            .into(mBinding.personImg)

        mBinding.swipe.isRefreshing = false
    }

}