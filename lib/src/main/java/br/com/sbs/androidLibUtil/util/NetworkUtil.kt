package br.com.sbs.androidLibUtil.util

import android.content.Context
import android.net.ConnectivityManager
import br.com.sbs.androidLibUtil.R
import br.com.sbs.androidLibUtil.exception.ConnectionException
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

/**
 * Created by Valmir Júnior on 13/12/2018.
 */

object NetworkUtil {
    private var cn:ConnectivityManager? = null
    private lateinit var queue: RequestQueue
    private var authorizationKey=""
    private var noConnectionMsg="noConnection"
    private var baseUrl=""

    fun isActive(): Boolean {
        val nf = this.cn?.activeNetworkInfo
        return nf != null && nf.isConnected
    }

    fun configure(context: Context, authorizationKey:String,baseUrl: String =""){
        cn = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        queue = Volley.newRequestQueue(context)
        this.authorizationKey = authorizationKey
        this.noConnectionMsg= context.getString(R.string.no_connection_with_internet)
        this.baseUrl= baseUrl
    }


    fun canDoRequest() {
        if (!isActive())
            throw ConnectionException(noConnectionMsg)
    }

    /***
     * Makes a Request Json
     */
    fun requestJson(method: Int, url: String, json: JSONObject?,
                    responseListener: Response.Listener<JSONObject>,
                    responseErrorListener: Response.ErrorListener) {
        queue.add(object : JsonObjectRequest(method, baseUrl + url,
                json, responseListener, responseErrorListener) {

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = authorizationKey
                return headers
            }
        })
    }


    /**
     * Makes a Request ArrayJson
     */
    fun requestArrayJson(method: Int, url: String, jsonArray: JSONArray?,
                         responseListener: Response.Listener<JSONArray>,
                         responseErrorListener: Response.ErrorListener) {
        queue.add(object : JsonArrayRequest(method, baseUrl+url,
                jsonArray, responseListener, responseErrorListener) {

            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["Authorization"] = authorizationKey
                return headers
            }
        })
    }
}