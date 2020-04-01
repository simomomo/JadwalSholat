package com.yudi.jadwalsholat.service.api

import android.content.Context
import com.yudi.jadwalsholat.api.models.prayerschedule.PrayerResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Yudi Rahmat
 */

interface APIInterface {

    companion object {
        operator fun invoke(baseUrl: String, mContext: Context): APIInterface {
            val baseService =
                APIService(
                    baseUrl,
                    mContext
                )

            return baseService.retrofit.create(APIInterface::class.java)
        }
    }

    @GET("v1/timingsByCity")
    fun loadData(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int
    ): Observable<PrayerResponse>
}

