package dk.aau.cs.psylog.sensor.light;

import dk.aau.cs.psylog.module_lib.SensorService;

public class PsyLogService extends SensorService
{
    @Override
    public void setSensor() {
        sensor = new LightListener(this);
    }
}
