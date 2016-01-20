package pl.edu.agh.fiss.android.rest.handler;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.rest.RestErrorHandler;
import org.springframework.core.NestedRuntimeException;

/**
 * Created by wemstar on 2016-01-19.
 */
@EBean
public class ErrorHandler implements RestErrorHandler {

    @RootContext
    Context context;

    private Activity activity;

    @Override
    public void onRestClientExceptionThrown(NestedRuntimeException e) {
        activity.runOnUiThread(new BackgroundExecutor.Task("",0,"")  {
            @Override
            public void execute() {
                new AlertDialog.Builder(context)
                        .setTitle("Serwer error")
                        .setMessage("Unexpected Serwer error")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
