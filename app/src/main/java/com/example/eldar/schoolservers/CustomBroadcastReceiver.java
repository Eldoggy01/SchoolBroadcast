package com.example.eldar.schoolservers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


public class CustomBroadcastReceiver extends BroadcastReceiver {
    ViewCallback mViewCallback;

    public CustomBroadcastReceiver(ViewCallback viewCallback) {
        this.mViewCallback = viewCallback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("GG","Зашли в onReceive");
        this.mViewCallback.onStatusChanged(intent.getSerializableExtra(MyIntentService.SEND_KEY));
    }
}