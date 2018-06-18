package com.example.eldar.schoolservers;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

public class MyIntentService extends IntentService {
    public static final String SEND_KEY = "DATA";
    public static final String FILTER = "com.example.eldar.SEND_MESSAGES_FILTER";
    public static final String RECEIVER_PERMISSION = "com.example.eldar.SEND_MESSAGES_PERMISSOIN";
    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("GG","Зашли в onHandleIntent");
        StateManager stateManager = StateManager.getInstance();
        stateManager.changeState();
        Intent broadcastIntent = new Intent(FILTER);
        broadcastIntent.putExtra(SEND_KEY,stateManager.getState());
        broadcastIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(broadcastIntent, Manifest.permission.Permission);
        Log.d("GG","Отправили широковещательное сообщение");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }


    public static final Intent newIntent(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        return intent;

    }


}
