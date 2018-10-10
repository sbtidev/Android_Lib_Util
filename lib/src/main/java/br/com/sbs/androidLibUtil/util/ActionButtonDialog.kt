package br.com.sbs.androidLibUtil.util

import android.content.DialogInterface


/**
 * Created by Valmir Júnior on 31/10/2017.
 * Class to represent an Action Button Dialog
 */
class ActionButtonDialog(var name: String?, var type: TYPE?,
                         var onClickListener: DialogInterface.OnClickListener?) {

    enum class TYPE {
        NEUTRAL, NEGATIVE, POSITIVE
    }
}
