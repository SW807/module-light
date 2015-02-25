package dk.aau.cs.psylog.psylog_lightmodule;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

public class LightListener implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;

    public LightListener(Context context) {
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            float lx = sensorEvent.values[0];
            Log.i("Light Readings", "Light:" + lx + " lx");
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void startSensor(){
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stopSensor() {

        mSensorManager.unregisterListener(this);
    }
}
