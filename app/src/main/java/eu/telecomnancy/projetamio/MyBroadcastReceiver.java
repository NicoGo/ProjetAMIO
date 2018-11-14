package eu.telecomnancy.projetamio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private SharedPreferences pref;

    public MyBroadcastReceiver() {
        Log.d("MyBroadcastReceiver", "Broadcast Receiver créé");
    }

    public void onReceive(Context c, Intent i)
    {
        Log.d("MyBroadcastReceiver","Broadcast reçu");
        pref = c.getSharedPreferences("checkbox", MODE_PRIVATE);

        final Intent intent = new Intent(c, MainService.class);

        Boolean parameter =  pref.getBoolean("checkbox", false);
        if (parameter != null) {
            if (parameter == true) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    c.startForegroundService(intent);
                }
            }
        } else {};

    }
} 