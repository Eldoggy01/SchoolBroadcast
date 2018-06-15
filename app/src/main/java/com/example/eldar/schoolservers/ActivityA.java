package com.example.eldar.schoolservers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {

TextView textView;
    private Messenger mService;
    final Messenger mMessenger = new Messenger(new IncomingHandler());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        init();
    }


    public void init(){
        textView = findViewById(R.id.textView3);
    }


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = new Messenger(service);
            Message msg = Message.obtain(null, MyService.MSG_REGISTER);
            msg.replyTo = mMessenger;
            msg.obj = "I'm senior";
            try {
                mService.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mService = null;
        }
    };


    private class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            textView.setText(msg.obj.toString());
        }
    }

    public static final Intent newIntent(Context context) {
        Intent intent = new Intent(context, ActivityA.class);
        return intent;
    }
}
