package dk.aau.cs.psylog.psylog_lightmodule;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LightSensorService extends Service
{
    boolean isRunning = false;
    LightListener lightListener;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy()
    {
        lightListener.stopSensor();
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flag, int startid)
    {
        if(!isRunning){
            isRunning = true;
            lightListener = new LightListener(this);
        }

        //Skal være START_STICKY hvis servicen skal køre hele tiden, selv hvis den bliver dræbt. START_NOT_STICKY hjælper når man programmere.
        return Service.START_NOT_STICKY;
    }

}
