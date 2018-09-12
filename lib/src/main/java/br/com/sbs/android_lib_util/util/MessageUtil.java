package br.com.sbs.android_lib_util.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import br.com.sbs.android_lib_util.R;

/**
 * Created by mvdkpj02r on 11/28/17.
 */

public class MessageUtil {


    /**
     * This method will be the responsible for the Showing a  Toast message
     * @param context   The {@link Context} that the {@link Toast} will use to the show the text
     * @param text  The text of message that will be showed in the {@link Toast}
     * @param duration
     */
    public static void showToast(Context context , String text, int duration){
        Toast.makeText(context,text,duration).show();
    }

    /**
     * This method show a Toast for um internal error
     * @param context
     */
    public static void showToastInternalError(Context context) {
        showToast(context,context.getString(R.string.internal_error), Toast.LENGTH_LONG);
    }

    private static AlertDialog.Builder prepareDialog(Context context, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        return builder;
    }

    /***
     * @param context
     * @param title
     * @param message
     * @return AlertDialog.Builder
     */

    public static AlertDialog.Builder createDialog(Context context, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        return builder;
    }

    /**
     * This Method creates an alert {@link AlertDialog.Builder}
     * @param context {@link Context} the context of the Dialog
     * @param title   {@link String}  the Title of the dialog
     * @param message {@link String}  the message body
     * */
    public static AlertDialog.Builder createDialogAlert(Context context, String title, String message){
        AlertDialog.Builder builder = prepareDialog(context,title,message);
        builder.setNegativeButton(context.getString(R.string.ok),null);
        builder.create();
        return builder;
    }

    /**
     * This Method creates an Confirmation {@link AlertDialog.Builder}
     * Important never forget of call the show() Method, otherwise the dialog not be displayed
     * @param context {@link Context} the context of the Dialog
     * @param title   {@link String}  the Title of the dialog
     * @param message {@link String}  the message body
     * @param listener {@link DialogInterface.OnClickListener} the confirmation action
     * */
    public static AlertDialog.Builder createDialogConfirmation(Context context, String title, String message,
                                                               DialogInterface.OnClickListener listener){
        AlertDialog.Builder builder = prepareDialog(context,title,message);
        builder.setPositiveButton(context.getString(R.string.confirm),listener);
        builder.setNegativeButton(context.getString(R.string.cancell),null);
        builder.create();
        return builder;
    }

    /**
     * This Method creates an {@link AlertDialog.Builder} with an {@link java.util.List< ActionButtonDialog >}
     * @param context {@link Context} the context of the Dialog
     * @param title   {@link String}  the Title of the dialog
     * @param message {@link String}  the message body
     * */
    public static AlertDialog.Builder createDialog(Context context, String title, String message,
                                                   ActionButtonDialog[] actionButtonDialog){
        AlertDialog.Builder builder = prepareDialog(context,title,message);
        if(actionButtonDialog != null){
            for (int i=0; i<actionButtonDialog.length; i++ ){
                switch (actionButtonDialog[i].getType()){
                    case NEGATIVE:
                        builder.setNegativeButton(actionButtonDialog[i].getName(),
                                actionButtonDialog[i].getOnClickListener());
                        break;
                    case NEUTRAL:
                        builder.setNeutralButton(actionButtonDialog[i].getName(),
                                actionButtonDialog[i].getOnClickListener());
                        break;
                    case POSITIVE:
                        builder.setPositiveButton(actionButtonDialog[i].getName(),
                                actionButtonDialog[i].getOnClickListener());
                        break;
                }
            }
        }
        builder.create();
        return builder;
    }

    public static void sendMessage(Handler handler, Bundle bundle ){
        Message message = new Message();
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
