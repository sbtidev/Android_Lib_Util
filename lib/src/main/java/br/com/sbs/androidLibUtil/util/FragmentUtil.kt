package br.com.sbs.androidLibUtil.util

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity

/**
 * Created by Valmir Júnior on 26/09/2017.
 */

object FragmentUtil {

    /**
     *
     * This method it's responsible for to do the replacement of an [Fragment]
     * in a [IdRes] of an [AppCompatActivity]
     * @param idContent  Id of the container layout to inflate the fragment
     * @param fragment   That will be replaced
     * @param activity   where is the idContent
     */
    fun replaceFragment(@IdRes idContent: Int, fragment: Fragment, activity: FragmentActivity,
                        addBackStack: Boolean = false, tag: String? = null) {
        val fm = activity.supportFragmentManager
        val ft = fm.beginTransaction()
        if (addBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(idContent, fragment)
        ft.commit()
    }
}
