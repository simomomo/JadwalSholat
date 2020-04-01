package com.yudi.jadwalsholat.app.modules

import com.yudi.jadwalsholat.api.repository.PrayerRepositories
import com.yudi.jadwalsholat.service.api.APIInterface
import com.yudi.jadwalsholat.app.common.Constant
import com.yudi.jadwalsholat.app.ui.viewmodel.PrayerViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * @author Yudi Rahmat
 */

val AppModule: Module = module {
    single {
        APIInterface(
            Constant.BASE_URL,
            androidContext()
        )
    }

    single {
        PrayerRepositories(
            get(),
            CompositeDisposable()
        )
    }

    viewModel {
        PrayerViewModel(get())
    }
}