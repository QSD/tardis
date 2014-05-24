package nl.qsd.tardis.modules.database.health;

import com.codahale.metrics.health.HealthCheck;

public interface DatabaseHealthCheck {
    public HealthCheck.Result check() throws Exception;
}
