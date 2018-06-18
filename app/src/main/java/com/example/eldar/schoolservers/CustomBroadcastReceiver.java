package com.example.eldar.schoolservers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class CustomBroadcastReceiver extends BroadcastReceiver {

    ViewCallback mViewCallback;

    public CustomBroadcastReceiver(ViewCallback viewCallback) {
        this.mViewCallback = viewCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mViewCallback.onStatusChanged(intent.getSerializableExtra(MyIntentService.SEND_KEY));
    }
}