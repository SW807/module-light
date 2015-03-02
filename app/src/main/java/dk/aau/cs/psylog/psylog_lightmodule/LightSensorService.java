package dk.aau.cs.psylog.psylog_lightmodule;

import dk.aau.cs.psylog.module_lib.SuperService;

public class LightSensorService extends SuperService
{
    @Override
    public void setSensor() {
        sensor = new LightListener(this);
    }
}
