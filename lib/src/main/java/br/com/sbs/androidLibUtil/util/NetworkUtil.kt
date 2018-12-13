package br.com.sbs.androidLibUtil.util

import android.content.Context
import android.net.ConnectivityManager


/**
 * Created by Valmir Júnior on 13/12/2018.
 */

object NetworkUtil {

    fun isActive(context: Context): Boolean {
        val cn = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val nf = cn?.activeNetworkInfo
        return nf != null && nf.isConnected
    }
}