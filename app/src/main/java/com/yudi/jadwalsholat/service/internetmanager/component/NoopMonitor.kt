package com.yudi.jadwalsholat.service.internetmanager.component

import com.yudi.jadwalsholat.service.internetmanager.other.Monitor

/**
 * @author Yudi Rahmat
 */

class NoopMonitor :
    Monitor {
    override fun onStart() { //no-op
    }

    override fun onStop() { //no-op
    }
}