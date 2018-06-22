package br.com.sbs.android_lib_util.util;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mvdkpj02r on 9/26/17.
 */

public class FragmentUtil {

    /**
     * <p>This method it's responsible for to do the replacement of an {@link Fragment}
     * in a {@link IdRes} of an {@link AppCompatActivity}</p>
     * @param idContent  Id of the container layout to inflate the fragment
     * @param fragment   That will be replaced
     * @param activity   where is the idContent
     */
    public static void replaceFragment(@IdRes int idContent, Fragment fragment, FragmentActivity activity){
        replaceFragment(idContent,fragment,activity,false);
    }

    /**
     * <p>This method it's responsible for to do the replacement of an {@link Fragment}
     * in a {@link IdRes} of an {@link AppCompatActivity}</p>
     * @param idContent  Id of the container layout to inflate the fragment
     * @param fragment   That will be replaced
     * @param activity   where is the idContent
     */
    public static void replaceFragment(@IdRes int idContent, Fragment fragment, FragmentActivity activity, boolean addBackStack){
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (addBackStack){
            ft.addToBackStack(null);
        }
        ft.replace(idContent,fragment);
        ft.commit();
    }
}
