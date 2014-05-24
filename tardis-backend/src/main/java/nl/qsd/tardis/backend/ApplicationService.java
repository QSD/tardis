package nl.qsd.tardis.backend;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.qsd.tardis.backend.status.DatabaseHealthCheckRestService;
import nl.qsd.tardis.backend.status.StatusModule;

import com.hubspot.dropwizard.guice.GuiceBundle;

public class ApplicationService extends Application<TardisConfiguration> {

    public static void main(String[] args) throws Exception {
        System.out.println("ping");
        new ApplicationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TardisConfiguration> bootstrap) {
        GuiceBundle<TardisConfiguration> guiceBundle = GuiceBundle.<TardisConfiguration>newBuilder()
                .addModule(new StatusModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(TardisConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(TardisConfiguration tardisConfiguration, Environment environment) throws Exception {
    }
}
