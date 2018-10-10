package br.com.sbs.androidLibUtil.util

import org.json.JSONException
import org.json.JSONObject

/**
 * Created by Valmir Júnior on 26/12/17.
 */

object JsonUtil {

    fun readKey(json: String, key: String): Any? {
        try {
            val jsonObject = JSONObject(json)
            return if (jsonObject.has(key)) jsonObject.opt(key) else null
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return null
    }
}
