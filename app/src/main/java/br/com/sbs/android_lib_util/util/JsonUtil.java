package br.com.sbs.android_lib_util.util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mvdkpj02 on 12/26/17.
 */

public class JsonUtil {

    public static Object readKey(String json, String key){
        try {
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject.has(key) ? jsonObject.opt(key) : null;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
