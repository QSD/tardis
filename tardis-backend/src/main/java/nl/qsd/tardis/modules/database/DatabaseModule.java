package nl.qsd.tardis.modules.database;

import com.google.inject.AbstractModule;
import nl.qsd.tardis.modules.database.health.DatabaseHealthCheck;
import nl.qsd.tardis.modules.database.health.DatabaseHealthCheckRestService;
import nl.qsd.tardis.modules.database.statistics.DatabaseStatistics;
import nl.qsd.tardis.modules.database.statistics.DatabaseStatisticsRestService;

public class DatabaseModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DatabaseHealthCheck.class).to(DatabaseHealthCheckRestService.class);
        bind(DatabaseStatistics.class).to(DatabaseStatisticsRestService.class);
    }
}
