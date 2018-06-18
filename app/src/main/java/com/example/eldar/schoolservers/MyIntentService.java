package com.example.eldar.schoolservers;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.List;

public class MyIntentService extends IntentService {
    public static final String SEND_KEY = "DATA";
    public static final String FILTER = "com.example.eldar.SEND_MESSAGES_FILTER";
    public static final String RECEIVER_PERMISSION = "com.example.eldar.SEND_MESSAGES_PERMISSOIN";
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        StateManager stateManager = StateManager.getInstance();
        stateManager.changeState();
        Intent broadcastIntent = new Intent(FILTER);
        broadcastIntent.putExtra(SEND_KEY,stateManager.getState());
        sendOrderedBroadcast(broadcastIntent,RECEIVER_PERMISSION);
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
