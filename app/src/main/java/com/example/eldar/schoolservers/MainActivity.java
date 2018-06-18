package com.example.eldar.schoolservers;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private CustomBroadcastReceiver mCustomBroadcastReceiver;
    private IntentFilter mIntentFilter;
    private Button mSendButton;
    private TextView mTextView;
    private View.OnClickListener myListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        init();
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mCustomBroadcastReceiver,mIntentFilter,MyIntentService.RECEIVER_PERMISSION,null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mCustomBroadcastReceiver);
    }

    private void init() {
        mCustomBroadcastReceiver = new CustomBroadcastReceiver(new ViewCallbackImpl());
        mIntentFilter = new IntentFilter(MyIntentService.FILTER);

    }

    private void initViews() {
        mSendButton = findViewById(R.id.sendButton);
        mTextView = findViewById(R.id.textView);
    }

    private void initListeners() {
        myListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //реализовать
                startService(MyIntentService.newIntent(MainActivity.this));
            }
        };
        mSendButton.setOnClickListener(myListener);

    }

    private class ViewCallbackImpl implements ViewCallback {

        @Override
        public void onStatusChanged(Serializable newStatus) {
            mTextView.setText(newStatus.toString());
        }
    }

}
