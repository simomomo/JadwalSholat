package com.yudi.jadwalsholat.app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yudi.jadwalsholat.api.interfaces.ApiCallBack
import com.yudi.jadwalsholat.api.models.prayerschedule.PrayerData
import com.yudi.jadwalsholat.api.models.prayerschedule.PrayerResponse
import com.yudi.jadwalsholat.api.repository.PrayerRepositories
import com.yudi.jadwalsholat.app.base.BaseViewModel
import com.yudi.jadwalsholat.app.common.Constant

/**
 * @author Yudi Rahmat
 */

class PrayerViewModel(
    private val prayerRepositories: PrayerRepositories
) : BaseViewModel<PrayerRepositories>(prayerRepositories) {

    private var prayerData: MutableLiveData<PrayerData> = MutableLiveData()
    private val prayerDataLive: LiveData<PrayerData> = prayerData
    
    fun loadData(city: String, country: String, method: Int) {
        prayerRepositories.loadData(city, country, method,
            object : ApiCallBack<PrayerResponse> {
                override fun onError(error: Throwable) {
                    Log.i(Constant.TAG, "status123 -- " + error.message)
                    // tag("Failed Get List").e(error)
                    processError(error)
                }

                override fun onSucess(response: PrayerResponse) {
                    prayerData.value = response.data
                    Log.i(Constant.TAG, "status123 -- " + response?.status)
                }
            })
    }

    fun getPrayerData(): LiveData<PrayerData> {
        return prayerDataLive
    }
}