package com.yudi.jadwalsholat.app.common

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yudi.jadwalsholat.R

/**
 * Created by Alvin Rusli on 1/24/2016.
 *
 * A class that handles basic universal methods.
 */
object Common {

    /** The loading progress dialog object */
    val MY_PERMISSIONS_REQUEST_LOCATION = 99;

    fun checkLocationPermission(activity: Activity): Boolean {
        if (ContextCompat.checkSelfPermission(activity,
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                            Manifest.permission.ACCESS_COARSE_LOCATION)) {
                val builder = AlertDialog.Builder(activity)
                builder.setTitle("Izinkan akses Lokasi")
                builder.setMessage("akses lokasi dibutuhkan untuk menentukan jadwal sesuai wilayah")
                builder.setPositiveButton(R.string.action_ok) { dialog, which ->
                    run {
                        ActivityCompat.requestPermissions(activity,
                                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                                MY_PERMISSIONS_REQUEST_LOCATION)
                    }
                }
                builder.setNegativeButton(R.string.action_cancel) { dialog, which -> dialog.cancel() }
                var dialog = builder.show()
                dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(activity, R.color.colorPrimaryDark))

            } else {
                ActivityCompat.requestPermissions(activity,
                        arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                        MY_PERMISSIONS_REQUEST_LOCATION)
            }
            return false
        } else {
            return true
        }
    }

    /**
     * Display a simple [Toast].
     * @param message The message string
     */
    fun showToast(ctx: Context, message: String?) {
        message?.let { Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show() }
    }

}
