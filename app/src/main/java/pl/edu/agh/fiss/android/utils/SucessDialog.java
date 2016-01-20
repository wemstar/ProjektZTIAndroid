package pl.edu.agh.fiss.android.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import org.androidannotations.api.BackgroundExecutor;

/**
 * Created by wemstar on 2016-01-20.
 */
public class SucessDialog {
    public static void sucesfullReturn(final Activity activity) {
        /*activity.runOnUiThread(new BackgroundExecutor.Task("", 0, "") {
            @Override
            public void execute() {
                new AlertDialog.Builder(activity.getApplicationContext())
                        .setTitle("Sucefuul")
                        .setMessage("Secuesfull Execution")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            }
        });*/
    }
}
