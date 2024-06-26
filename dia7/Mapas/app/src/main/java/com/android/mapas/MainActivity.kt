package com.android.mapas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback  {

    private lateinit var map : GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createMapFragment()
    }

    private fun createMapFragment(){

        val mapFragment = supportFragmentManager.findFragmentById(R.id.fragmentMap) as SupportMapFragment

        mapFragment.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarkerPin()
    }

    private fun createMarkerPin(){
        val place = LatLng(-2.1336456,-79.9045489)
        map.addMarker(MarkerOptions().position(place).title("Desde donde dicto el curso"))
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(place, 20f),
            4000,
            null
        )
    }

}