package br.com.sbs.androidLibUtil.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast

import br.com.sbs.androidLibUtil.R

/**
 * Created by Valmir Júnior on 28/11/2017.
 */

object MessageUtil {

    var internalErrorMsg:String?=null
    var confirmMsg:String?=null
    var cancelMsg:String?=null
    var okMsg:String?=null


    /**
     * This method will be the responsible for the Showing a  Toast message
     * @param context   The [Context] that the [Toast] will use to the show the text
     * @param text  The text of message that will be showed in the [Toast]
     * @param duration
     */
    fun showToast(context: Context, text: String, duration: Int) {
        Toast.makeText(context, text, duration).show()
    }

    /**
     * This method show a Toast for um internal error
     * @param context
     */
    fun showToastInternalError(context: Context) {
        showToast(context, internalErrorMsg?:context.getString(R.string.internal_error), Toast.LENGTH_LONG)
    }

    private fun prepareDialog(context: Context, title: String, message: String): AlertDialog.Builder {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        return builder
    }

    /***
     * @param context
     * @param title
     * @param message
     * @return AlertDialog.Builder
     */

    fun createDialog(context: Context, title: String, message: String): AlertDialog.Builder {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        return builder
    }

    /**
     * This Method creates an alert [AlertDialog.Builder]
     * @param context [Context] the context of the Dialog
     * @param title   [String]  the Title of the dialog
     * @param message [String]  the message body
     */
    fun createDialogAlert(context: Context, title: String, message: String): AlertDialog.Builder {
        val builder = prepareDialog(context, title, message)
        builder.setNegativeButton(okMsg ?: context.getString(R.string.ok), null)
        builder.create()
        return builder
    }

    /**
     * This Method creates an Confirmation [AlertDialog.Builder]
     * Important never forget of call the show() Method, otherwise the dialog not be displayed
     * @param context [Context] the context of the Dialog
     * @param title   [String]  the Title of the dialog
     * @param message [String]  the message body
     * @param listener [DialogInterface.OnClickListener] the confirmation action
     */
    fun createDialogConfirmation(context: Context, title: String, message: String,
                                 listener: DialogInterface.OnClickListener): AlertDialog.Builder {
        val builder = prepareDialog(context, title, message)
        builder.setPositiveButton(confirmMsg ?: context.getString(R.string.confirm), listener)
        builder.setNegativeButton(cancelMsg ?: context.getString(R.string.cancell), null)
        builder.create()
        return builder
    }

    /**
     * This Method creates an [AlertDialog.Builder] with an [ ][<]
     * @param context [Context] the context of the Dialog
     * @param title   [String]  the Title of the dialog
     * @param message [String]  the message body
     */
    fun createDialog(context: Context, title: String, message: String,
                     actionButtonDialog: Array<ActionButtonDialog>?): AlertDialog.Builder {
        val builder = prepareDialog(context, title, message)
        if (actionButtonDialog != null) {
            for (i in actionButtonDialog.indices) {
                when (actionButtonDialog[i].type) {
                    ActionButtonDialog.TYPE.NEGATIVE -> builder.setNegativeButton(actionButtonDialog[i].name,
                            actionButtonDialog[i].onClickListener)
                    ActionButtonDialog.TYPE.NEUTRAL -> builder.setNeutralButton(actionButtonDialog[i].name,
                            actionButtonDialog[i].onClickListener)
                    ActionButtonDialog.TYPE.POSITIVE -> builder.setPositiveButton(actionButtonDialog[i].name,
                            actionButtonDialog[i].onClickListener)
                }
            }
        }
        builder.create()
        return builder
    }

    /***
     * Send a bundle data to a handler with a Message
     */
    fun sendMessage(handler: Handler, bundle: Bundle) {
        val message = Message()
        message.data = bundle
        handler.sendMessage(message)
    }
}
