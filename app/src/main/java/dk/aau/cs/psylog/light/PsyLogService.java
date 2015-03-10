package dk.aau.cs.psylog.light;

import dk.aau.cs.psylog.module_lib.SuperService;

public class PsyLogService extends SuperService
{
    @Override
    public void setSensor() {
        sensor = new LightListener(this);
    }
}
