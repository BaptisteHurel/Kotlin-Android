package com.example.tpfirebase.ui.geolocalisation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.tpfirebase.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class GeolocalisationFragment : AppCompatActivity(), LocationListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        checkLocation()
    }

    private fun checkLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            val locationManager = getSystemService(AppCompatActivity.LOCATION_SERVICE) as LocationManager
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0F, this)
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_PERMISSION_ACCESS_FINE_LOCATION)
        }
    }

    override fun onLocationChanged(location: Location) {
        val textViewLocation: TextView = findViewById(R.id.textViewLocation)
        textViewLocation.text = "longitude : ${location.longitude} , latitude ${location.latitude}"

        val btnLocation: Button = findViewById(R.id.btnSaveToFireStore)

        btnLocation.setOnClickListener {

            val mapLocation = hashMapOf(
                    "latitude" to location.latitude,
                    "longitude" to location.longitude,
            )

            Firebase.firestore
                    .collection("localisation")
                    .add(mapLocation)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Log.e("connection Fail", it.message.toString())
                    }

        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if (requestCode == REQUEST_PERMISSION_ACCESS_FINE_LOCATION){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                checkLocation()
        }

    }

    companion object{
        const val REQUEST_PERMISSION_ACCESS_FINE_LOCATION = 1
    }
}