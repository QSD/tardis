package nl.qsd.tardis.backend.status;

import com.codahale.metrics.health.HealthCheck;

public interface DatabaseHealthCheck {
    public HealthCheck.Result check() throws Exception;
}
