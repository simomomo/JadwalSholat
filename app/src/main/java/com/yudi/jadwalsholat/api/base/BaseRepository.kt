package com.yudi.jadwalsholat.api.base

import com.yudi.jadwalsholat.api.interfaces.ApiCallBack
import com.yudi.jadwalsholat.api.interfaces.Unsubscribe
import com.yudi.jadwalsholat.service.api.APIInterface
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * @author Yudi Rahmat
 */

open class BaseRepository(
    @PublishedApi internal val service: APIInterface,
    @PublishedApi internal val compositeDisposable: CompositeDisposable
) : Unsubscribe {

    override fun unSubscribe() {
        compositeDisposable.clear()
    }

    inline fun <reified T : Any> fetchData(
        function: Observable<T>,
        callBack: ApiCallBack<T>
    ) {

        compositeDisposable.add(function
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callBack.onStart() }
            .subscribeWith(subscribe(callBack))
        )
    }

    fun <T> subscribe(callback: ApiCallBack<T>): DisposableObserver<T> {
        return object : DisposableObserver<T>() {
            override fun onComplete() {
                callback.onComplete()
            }

            override fun onNext(t: T) {
                callback.onSucess(t)
            }

            override fun onError(e: Throwable) {
                callback.onError(e)
            }
        }
    }

}