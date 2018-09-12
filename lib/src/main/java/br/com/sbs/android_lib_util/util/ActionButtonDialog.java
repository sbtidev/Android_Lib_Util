package br.com.sbs.android_lib_util.util;

import android.content.DialogInterface;


/**
 * Created by mvdkpj02r on 10/31/17.
 * Class to represent
 */
public class ActionButtonDialog {
    private DialogInterface.OnClickListener onClickListener;
    private String name;
    private TYPE type;

    public ActionButtonDialog(String name, TYPE type,
                              DialogInterface.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.name = name;
        this.type = type;
    }

    public DialogInterface.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(DialogInterface.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public static enum TYPE {
        NEUTRAL, NEGATIVE, POSITIVE;
    }


}
