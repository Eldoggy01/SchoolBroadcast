package com.example.eldar.schoolservers;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    private final static int MODE = Service.START_NOT_STICKY;
    public final static int MSG_REGISTER = 11;
    private List<Messenger> clients = new ArrayList<>();

    Messenger messenger = new Messenger(new IncomingHandler());
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return MODE;
    }


    private class IncomingHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MSG_REGISTER:
                    clients.add(msg.replyTo);
            }

        }
    }

    public static final Intent newIntent(Context context){
        Intent intent = new Intent(context, MyService.class);
        return intent;
    }


}
