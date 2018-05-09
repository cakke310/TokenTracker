package com.tokentracker.Util;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.tokentracker.R;


public class DialogLoading extends Dialog {

    private TextView loadingLabel;

    public DialogLoading(Context context) {
        super(context, R.style.Dialog);
        setContentView(R.layout.dialog_loading_layout);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        loadingLabel = (TextView) findViewById(R.id.loading_text);
    }


    public void setDialogLabel(String label) {
        loadingLabel.setText(label);
    }

}
