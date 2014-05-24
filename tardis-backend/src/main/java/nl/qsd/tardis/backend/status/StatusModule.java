package nl.qsd.tardis.backend.status;

import com.google.inject.AbstractModule;
import nl.qsd.tardis.modules.database.health.DatabaseHealthCheck;
import nl.qsd.tardis.modules.database.health.DatabaseHealthCheckRestService;

public class StatusModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Status.class).to(StatusRestService.class);
    }
}
