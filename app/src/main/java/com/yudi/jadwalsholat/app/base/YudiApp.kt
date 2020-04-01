package com.yudi.jadwalsholat.app.base

import androidx.multidex.MultiDexApplication
import com.yudi.jadwalsholat.app.modules.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Yudi Rahmat
 */

class YudiApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(listOf(AppModule))
        }

    }

}