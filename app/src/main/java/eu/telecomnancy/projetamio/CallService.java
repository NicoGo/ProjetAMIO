package eu.telecomnancy.projetamio;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;

public class CallService extends Service {

    Timer timer = new Timer();
    TimerTask task;

    public CallService()
    {
        Log.d("Main service","Service constructor");
        timer();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.d("Main service","On start command");
        return START_STICKY;
    }



    public void timer()
    {
        task = new TimerTask() {
            public void run() {

                WebServiceCall wb = new WebServiceCall(getApplicationContext());
                wb.execute();
                Log.d("Main Service", "Log récurrent 3 S");
            }
        };
        timer.schedule(task, 0, 3000);
    }

    public void onDestroy() {
        Log.d("Main service","Destroy service");
        timer.cancel();
        super.onDestroy(); }
}
