package dk.aau.cs.psylog.light;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.util.Log;
import dk.aau.cs.psylog.module_lib.DBAccessContract;
import dk.aau.cs.psylog.module_lib.ISensor;

public class LightListener implements SensorEventListener, ISensor {

    private SensorManager mSensorManager;
    private Sensor mSensor;

    private ContentResolver resolver;

    private int sensorDelay;

    public LightListener(Context context) {
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        resolver = context.getContentResolver();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lx = sensorEvent.values[0];

            Uri uri = Uri.parse(DBAccessContract.DBACCESS_CONTENTPROVIDER + "illuminance");

            ContentValues content = new ContentValues();
            content.put("lux", lx);

            resolver.insert(uri, content);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void startSensor(){
        mSensorManager.unregisterListener(this);
        mSensorManager.registerListener(this, mSensor, sensorDelay);
    }

    public void stopSensor() {

        mSensorManager.unregisterListener(this);
    }

    @Override
    public void sensorParameters(Intent intent) {
        Log.d("lightmodule","Lightmodule set to " + intent.getIntExtra("sensorDelay",-1));

        sensorDelay = intent.getIntExtra("sensorDelay",SensorManager.SENSOR_DELAY_NORMAL); //default set to slowest update
    }
}
