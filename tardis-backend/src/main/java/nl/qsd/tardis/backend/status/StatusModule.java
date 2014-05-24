package nl.qsd.tardis.backend.status;

import com.google.inject.AbstractModule;

public class StatusModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Status.class).to(StatusRestService.class);
        bind(DatabaseHealthCheck.class).to(DatabaseHealthCheckRestService.class);
    }
}
