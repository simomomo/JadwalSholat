package com.yudi.jadwalsholat.service.internetmanager.component

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import com.yudi.jadwalsholat.service.internetmanager.other.Monitor
import com.yudi.jadwalsholat.service.internetmanager.other.MonitorFactory

/**
 * @author Yudi Rahmat
 */

class DefaultMonitorFactory :
    MonitorFactory {
    @NonNull
    override fun create(
        context: Context?,
        connectionType: Int,
        listener: Monitor.ConnectivityListener?
    ): Monitor? {
        val permissionResult: Int? = context?.let {
            ContextCompat.checkSelfPermission(
                it,
                ACCESS_NETWORK_PERMISSION
            )
        }
        val hasPermission = permissionResult == PackageManager.PERMISSION_GRANTED
        return if (hasPermission) context?.let {
            listener?.let { it1 ->
                DefaultMonitor(
                    it,
                    it1,
                    connectionType
                )
            }
        } else NoopMonitor()
    }


    companion object {
        const val ACCESS_NETWORK_PERMISSION =
            Manifest.permission.ACCESS_NETWORK_STATE
    }

}