package com.yudi.jadwalsholat.app.common

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author Yudi Rahmat
 */

fun isConnectedToInternet(context: Context?): Boolean {
    return try {
        if (context != null) {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
        false
    } catch (e: Exception) {
        // tag("Failed Check Connection").e(e)
        false
    }
}

fun getDate(timestampInMilliSeconds: Long?, pattern: String): String? {
    val date = Date()
    if (timestampInMilliSeconds != null) {
        date.time = timestampInMilliSeconds
    }

    return SimpleDateFormat(pattern).format(date)
}

/**
 * @param action dipakai untuk mendefinisikan aksi yang dilakukan ketika back ditekan
 * @param enableBack digunakan untuk enable atau disable back action
 */

fun setupBackButtonHandler(action: Runnable, fragment: Fragment, enableBack: Boolean) {
    val callback: OnBackPressedCallback =
        object : OnBackPressedCallback(enableBack /* enabled by default */) {
            override fun handleOnBackPressed() {
                action.run()
            }
        }
    fragment.requireActivity().onBackPressedDispatcher.addCallback(fragment, callback)
}

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun slideIn(view: View, parent: ViewGroup) {
    val transition: Transition = Slide(Gravity.BOTTOM)
    transition.duration = 600
    transition.addTarget(view)
    TransitionManager.beginDelayedTransition(parent, transition)
    view.visibility = if (view.visibility == View.GONE) View.VISIBLE else View.GONE
}

fun navigateTo(fragment: Fragment, destination: Int, bundle: Bundle) {
    try {
        findNavController(fragment).navigate(destination, bundle)
    } catch (e: java.lang.Exception) {
        // tag("Failed Navigating").e(e)
    }
}

fun navigateTo(fragment: Fragment, destination: Int) {
    try {
        findNavController(fragment).navigate(destination)
    } catch (e: java.lang.Exception) {
        // tag("Failed Navigating").e(e)
    }
}


