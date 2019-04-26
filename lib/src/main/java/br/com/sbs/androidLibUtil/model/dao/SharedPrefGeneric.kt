package br.com.sbs.androidLibUtil.model.dao

import android.content.Context
import com.google.gson.Gson

/**
 * Created by Valmir Júnior on 9/29/17.
 */

class SharedPrefGeneric(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)
    private var editor = sharedPreferences.edit()
    private val gson = Gson()


    fun saveObject(any: Any, key: String) {
        saveString(key, gson.toJson(any))
    }

    fun saveString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun removeString(key: String) {
        editor.remove(key)
        editor.commit()
    }

    fun <T> getObject(classOf: Class<T>, key: String): T? {
        return gson.fromJson(getString(key), classOf)
    }

    fun getString(key: String): String {
        return sharedPreferences.getString(key, "")
    }

    companion object {
        var PREFERENCE_KEY = "PREFERENCE_KEY"
    }
}
