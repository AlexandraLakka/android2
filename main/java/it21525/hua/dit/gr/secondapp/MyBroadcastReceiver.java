package it21525.hua.dit.gr.secondapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //https://androidclarified.com/broadcast-receivers-example/
        //if (intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
        Toast.makeText(context, "AIRPLANE MODE STATUS CHANGED", Toast.LENGTH_SHORT).show();
        context.startService(new Intent(context, MyService.class));
        Toast.makeText(context, "Service started", Toast.LENGTH_SHORT).show();
        if(isAirplaneModeOn(context) == false){
            context.stopService(new Intent(context, MyService.class));
            Toast.makeText(context, "Service stopped", Toast.LENGTH_SHORT).show();
        }

        //}

    }
    //https://stackoverflow.com/questions/4319212/how-can-one-detect-airplane-mode-on-android
    private static boolean isAirplaneModeOn(Context context) {

        return Settings.System.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

    }


}