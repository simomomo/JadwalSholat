package com.yudi.jadwalsholat.service.internetmanager.component

import java.util.*

/**
 * @author Yudi Rahmat
 */

object Util {
    fun <T> getSnapshot(other: Collection<T>): List<T> {
        val result: MutableList<T> = ArrayList(other.size)
        for (item in other) {
            result.add(item)
        }
        return result
    }
}