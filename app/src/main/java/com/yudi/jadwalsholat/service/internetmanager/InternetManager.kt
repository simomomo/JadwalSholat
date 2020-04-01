package com.yudi.jadwalsholat.service.internetmanager

import android.content.Context
import android.util.Log
import com.yudi.jadwalsholat.service.internetmanager.component.DefaultMonitorFactory
import com.yudi.jadwalsholat.service.internetmanager.other.Monitor
import java.lang.ref.WeakReference
import java.util.*

class InternetManager private constructor(context: Context) {
    private val contextRef: WeakReference<Context>
    private val monitors: MutableSet<Monitor>
    fun monitor(
        connectionType: Int,
        listener: Monitor.ConnectivityListener?
    ) {
        val context = contextRef.get()
        if (context != null) DefaultMonitorFactory().create(
            context,
            connectionType,
            listener!!
        )?.let {
            monitors.add(
                it
            )
        }
        start()
    }

    fun monitor(listener: Monitor.ConnectivityListener?) {
        monitor(-1, listener)
    }

    fun start() {
        for (monitor in monitors) {
            monitor.onStart()
        }
        if (monitors.size > 0) Log.i(TAG, "started InternetManager")
    }

    fun stop() {
        for (monitor in monitors) {
            monitor.onStop()
        }
    }

    companion object {
        private const val TAG = "InternetManager"
        private val lock = Any()
        @Volatile
        private var InternetManager: InternetManager? = null

        fun from(context: Context): InternetManager? {
            if (InternetManager == null) {
                synchronized(lock) {
                    if (InternetManager == null) {
                        InternetManager = InternetManager(context)
                    }
                }
            }
            return InternetManager
        }
    }

    init {
        monitors = HashSet()
        contextRef = WeakReference(context)
    }
}