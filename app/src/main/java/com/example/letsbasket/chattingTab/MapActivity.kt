package com.example.letsbasket

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import net.daum.mf.map.api.MapCircle
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView


class MapActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val mapView = MapView(this)

        val mapViewContainer = findViewById<View>(R.id.map_view) as ViewGroup
        mapViewContainer.addView(mapView)

        val circle1 = MapCircle(
            MapPoint.mapPointWithGeoCoord(37.537094, 127.005470),  // center
            500,  // radius
            Color.argb(128, 255, 0, 0),  // strokeColor
            Color.argb(128, 0, 255, 0) // fillColor
        )
        circle1.tag = 1234
        mapView.addCircle(circle1)
    }

}