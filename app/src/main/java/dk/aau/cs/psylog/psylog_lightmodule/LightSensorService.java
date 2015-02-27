package dk.aau.cs.psylog.psylog_lightmodule;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import dk.aau.cs.psylog.module_lib.SuperService;

public class LightSensorService extends SuperService
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        sensor = new LightListener(this);
    }
}
