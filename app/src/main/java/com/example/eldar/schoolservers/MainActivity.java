package com.example.eldar.schoolservers;

import android.content.ComponentName;
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

public class MainActivity extends AppCompatActivity {

    Button serviceButton;
    Button secondActivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }



    public void init() {
        serviceButton = findViewById(R.id.serviceButton);
        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //реализовать
                startService(MyService.newIntent(MainActivity.this));
            }
        });

        secondActivityButton = findViewById(R.id.secondActivityButton);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ActivityA.newIntent(MainActivity.this));
            }
        });
    }

}
