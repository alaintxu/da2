package com.alainperez.da2.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import com.alainperez.da2.R;

/**
 * Created by aperez on 9/11/13.
 */


public class ExitDialog implements OnClickListener {

    private Activity activity;
    public ExitDialog(Activity activity){
        this.activity	=	activity;
    }
    public void startDialog(){
        AlertDialog.Builder builder;
        final AlertDialog alertDialog;
        builder = new AlertDialog.Builder(activity);

        builder.setMessage(R.string.exit_message);
        builder.setPositiveButton(R.string.yes,this);
        builder.setNegativeButton(R.string.no, this);
        alertDialog = builder.create();


        //Mostramos el alertdialog
        alertDialog.show();
    }
    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==-1){
            activity.finish();
        }else{
            dialog.cancel();
        }

    }
}
