package com.example.eldar.schoolservers;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.List;

public class MyIntentService extends IntentService {

    List <Class>

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String state = intent.getStringExtra("stateExtra");

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public static final Intent getIntentForSend(Context context, String message){
       Intent intent = newIntent(context);
       intent.putExtra("stateExtra",message);
       return intent;

    }

    private static final Intent newIntent(Context context){
        Intent intent = new Intent(context, MyIntentService.class);
        return intent;

    }
}
