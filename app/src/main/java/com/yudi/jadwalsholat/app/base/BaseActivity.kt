package com.yudi.jadwalsholat.app.base

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil.setContentView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.yudi.jadwalsholat.service.internetmanager.other.Monitor
import com.google.android.material.snackbar.Snackbar
import com.yudi.jadwalsholat.R
import com.yudi.jadwalsholat.app.common.Common
import com.yudi.jadwalsholat.app.common.Constant
import com.yudi.jadwalsholat.databinding.BaseContainerBinding
import com.yudi.jadwalsholat.service.internetmanager.InternetManager
import java.lang.Exception
import java.util.*

/**
 * @author Yudi Rahmat
 */

class BaseActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var initFlag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<BaseContainerBinding>(this, R.layout.base_container)
        connectivityMonitor(this)

        Common.checkLocationPermission(this)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        obtieneLocalizacion()
    }

    @SuppressLint("MissingPermission")
    private fun obtieneLocalizacion() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                fetchData(location)
            }
    }

    private fun fetchData(location: Location?) {
        var city: String? = "Bandung"

        try {
            val geocoder = Geocoder(this, Locale.getDefault())
            val addresses = geocoder.getFromLocation(location!!.latitude, location!!.longitude, 1)

            if (addresses.size > 0) {
                city = addresses.get(0).subAdminArea
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun connectivityMonitor(activity: Activity) {
        InternetManager.from(this)?.monitor(object : Monitor.ConnectivityListener {
            override fun onConnectivityChanged(connectionType: Int, isConnected: Boolean, isFast: Boolean) {
                if(isConnected) {
                    if(initFlag) initFlag = false else
                        Snackbar.make(findViewById(android.R.id.content), Constant.CONNECTIVITY_ON, Snackbar.LENGTH_LONG)
                            .setBackgroundTint(ContextCompat.getColor(activity,R.color.colorGreen))
                            .setActionTextColor(ContextCompat.getColor(activity,R.color.colorWhite_75))
                            .show()
                } else {
                    if(initFlag) initFlag = false else
                        Snackbar.make(findViewById(android.R.id.content), Constant.CONNECTIVITY_OFF, Snackbar.LENGTH_LONG)
                            .setBackgroundTint(ContextCompat.getColor(activity,R.color.colorRed))
                            .setActionTextColor(ContextCompat.getColor(activity,R.color.colorWhite_75))
                            .show()
                }
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            Common.MY_PERMISSIONS_REQUEST_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        obtieneLocalizacion()
                    } else {
                        Common.checkLocationPermission(this)
                    }
                    return
                }
                else{
                    Common.checkLocationPermission(this)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        InternetManager.from(this)?.stop()
    }

}