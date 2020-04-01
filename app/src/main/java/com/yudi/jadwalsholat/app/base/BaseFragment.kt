package com.yudi.jadwalsholat.app.base

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.fragment.app.Fragment
import com.yudi.jadwalsholat.R
import kotlinx.android.synthetic.main.view_warning_dialog.view.*

/**
 * @author Yudi Rahmat
 */

open class BaseFragment : Fragment() {
    private var mProgressBar: AlertDialog? = null
    private var mWarningDialog: AlertDialog? = null

    fun showProgressBarDialog(isCancelAble: Boolean, mContext: Context) {
        try {
            val dialogBuilder =
                AlertDialog.Builder(mContext)
            val inflater = this.layoutInflater
            val view =
                inflater.inflate(R.layout.view_loading_progressdialog, null)
            dialogBuilder.setView(view)
            dialogBuilder.setCancelable(isCancelAble)
            mProgressBar = dialogBuilder.create()
            mProgressBar!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mProgressBar!!.window!!.attributes.windowAnimations =
                R.style.FadeDialogAnimation
            mProgressBar!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun dismissProgressBarDialog() {
        try {
            if (mProgressBar != null) mProgressBar!!.dismiss()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun showWarningDialog(mContext: Context, title: String, message: String) {
        try {
            val dialogBuilder =
                AlertDialog.Builder(mContext)
            val inflater = this.layoutInflater
            val view =
                inflater.inflate(R.layout.view_warning_dialog, null)
            view.tvTitle.text = title
            view.tvMessage.text = message
            dialogBuilder.setView(view)
            dialogBuilder.setCancelable(true)
            mWarningDialog = dialogBuilder.create()
            mWarningDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mWarningDialog!!.window!!.attributes.windowAnimations =
                R.style.FadeDialogAnimation
            mWarningDialog!!.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}