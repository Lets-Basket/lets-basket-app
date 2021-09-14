package com.example.letsbasket

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_map.*
import net.daum.mf.map.api.*


class MapActivity : Activity(), MapView.CurrentLocationEventListener,
    MapReverseGeoCoder.ReverseGeoCodingResultListener{
    val PERMISSIONS_REQUEST_CODE = 100
    var REQUIRED_PERMISSIONS = arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION)
    lateinit var mapView : MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // map view 설정정
        val mapView = MapView(this)
        val mapViewContainer = map_view
        mapViewContainer.addView(mapView)

        val latitude = 37.546294647182776
        val longitude = 126.9673619657574
//        val latitude = 37.54411423022556
//        val longitude = 126.9673657452421



//        map_page_location_btn.setOnClickListener {
//            val permissionCheck =
//                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//                val lm: LocationManager =
//                    getSystemService(Context.LOCATION_SERVICE) as LocationManager
//                try {
//                    val userNowLocation: Location? =
//                        lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
//                    val uLatitude = userNowLocation?.latitude
//                    val uLongitude = userNowLocation?.longitude
//                    val uNowPosition = MapPoint.mapPointWithGeoCoord(uLatitude!!, uLongitude!!)
//                    mapView.setMapCenterPoint(uNowPosition, true)
//                    Log.e("현재위치", uLatitude.toString() + "/" + uLongitude.toString())
//                } catch (e: NullPointerException) {
//                    Log.e("LOCATION_ERROR", e.toString())
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                        ActivityCompat.finishAffinity(this)
//                    } else {
//                        ActivityCompat.finishAffinity(this)
//                    }
//
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                    System.exit(0)
//                }
//            } else {
//                Toast.makeText(this, "위치 권한이 없습니다.", Toast.LENGTH_SHORT).show()
//                ActivityCompat.requestPermissions(
//                    this,
//                    REQUIRED_PERMISSIONS,
//                    PERMISSIONS_REQUEST_CODE
//                )
//            }
//        }


        // 마커 표시
        val marker = MapPOIItem()
        marker.itemName = "베이글 팩토리"
        marker.tag = 0
        marker.mapPoint = MapPoint.mapPointWithGeoCoord(latitude, longitude)
        marker.markerType = MapPOIItem.MarkerType.BluePin // 기본으로 제공하는 BluePin 마커 모양.
        marker.selectedMarkerType =
            MapPOIItem.MarkerType.RedPin // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        mapView.addPOIItem(marker)

        // 반경 설정
        val circle1 = MapCircle(
            MapPoint.mapPointWithGeoCoord(latitude, longitude),  // center
            50,  // radius
            Color.argb(128, 255, 0, 0),  // strokeColor
            Color.argb(128, 0, 255, 0) // fillColor
        )
        circle1.tag = 1234
        mapView.addCircle(circle1)

        // 지도뷰의 중심좌표와 줌레벨을 Circle이 모두 나오도록 조정.
        val padding = 50 // px

        mapView.moveCamera(CameraUpdateFactory.newMapPointBounds(circle1.bound, padding))
    }


    // 추가
    override fun onDestroy() {
        super.onDestroy()
//        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOff)
//        mapView.setShowCurrentLocationMarker(false)
    }

    override fun onCurrentLocationUpdate(
        mapView: MapView?,
        currentLocation: MapPoint,
        accuracyInMeters: Float
    ) {
        val mapPointGeo = currentLocation.mapPointGeoCoord
        Log.i(
            "요놈",
            String.format(
                "MapView onCurrentLocationUpdate (%f,%f) accuracy (%f)",
                mapPointGeo.latitude,
                mapPointGeo.longitude,
                accuracyInMeters
            )
        )
    }


    override fun onCurrentLocationDeviceHeadingUpdate(
        mapView: MapView?,
        v: Float
    ) {
    }

    override fun onCurrentLocationUpdateFailed(mapView: MapView?) {}

    override fun onCurrentLocationUpdateCancelled(mapView: MapView?) {}

    override fun onReverseGeoCoderFoundAddress(
        mapReverseGeoCoder: MapReverseGeoCoder,
        s: String
    ) {
        mapReverseGeoCoder.toString()
        onFinishReverseGeoCoding(s)
    }

    override fun onReverseGeoCoderFailedToFindAddress(mapReverseGeoCoder: MapReverseGeoCoder?) {
        onFinishReverseGeoCoding("Fail")
    }

    private fun onFinishReverseGeoCoding(result: String) {
        Toast.makeText(this, "Reverse Geo-coding : " + result, Toast.LENGTH_SHORT).show();
    }
//
//    override fun onCurrentLocationUpdate(p0: MapView?, p1: MapPoint?, p2: Float) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onCurrentLocationDeviceHeadingUpdate(p0: MapView?, p1: Float) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onCurrentLocationUpdateFailed(p0: MapView?) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onCurrentLocationUpdateCancelled(p0: MapView?) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onReverseGeoCoderFoundAddress(p0: MapReverseGeoCoder?, p1: String?) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onReverseGeoCoderFailedToFindAddress(p0: MapReverseGeoCoder?) {
//        TODO("Not yet implemented")
//    }

}