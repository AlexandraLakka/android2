package it21525.hua.dit.gr.secondapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyBroadcastReceiver receiver;
    private IntentFilter filter;
    public static String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText id = findViewById(R.id.userid);
        final Button registerButton = findViewById(R.id.register);


        //broadcastreceiver
        receiver = new MyBroadcastReceiver();

        filter = new IntentFilter();
        filter.addAction(Settings.Global.AIRPLANE_MODE_ON);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId = id.getText().toString();

                registerReceiver(receiver, filter);
                //Toast.makeText(MainActivity.this, "Insert", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, filter);
    }


    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
