package com.yudi.jadwalsholat.api.repository

import com.yudi.jadwalsholat.api.base.BaseRepository
import com.yudi.jadwalsholat.api.interfaces.ApiCallBack
import com.yudi.jadwalsholat.api.models.prayerschedule.PrayerResponse
import com.yudi.jadwalsholat.service.api.APIInterface
import io.reactivex.disposables.CompositeDisposable

/**
 * @author Yudi Rahmat
 */

class PrayerRepositories(service: APIInterface, compositeDisposable: CompositeDisposable) :
    BaseRepository(service, compositeDisposable) {

    fun loadData(
        city: String, country: String, method: Int,
        callback: ApiCallBack<PrayerResponse>
    ) {
        fetchData(service.loadData(city, country, method), callback)
    }

}

