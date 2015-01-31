package com.gmt.util;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by apple on 1/25/15.
 */
public class CommonUtil {

    public static ProgressDialog showDialog(Activity context, @SuppressWarnings("SameParameterValue") String strContent)
    {
        if (context != null)
        {
            ProgressDialog infoDialog = new ProgressDialog(context);
            infoDialog.setMessage(strContent);
            infoDialog.show();
            return infoDialog;
        }
        return null;
    }

    public static void dismissDialog(ProgressDialog infoDialog)
    {
        if (infoDialog != null)
        {
            infoDialog.dismiss();
        }
    }
}
