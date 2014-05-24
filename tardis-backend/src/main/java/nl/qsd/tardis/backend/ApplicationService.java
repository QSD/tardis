package nl.qsd.tardis.backend;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.qsd.tardis.backend.status.StatusResource;

public class ApplicationService extends Application<TardisConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TardisConfiguration> tardisConfigurationBootstrap) {

    }

    @Override
    public void run(TardisConfiguration tardisConfiguration, Environment environment) throws Exception {

//        final Thingy thingy = config.getThingyFactory().build();
//        environment.jersey().register(new ThingyResource(thingy));

    }
}
