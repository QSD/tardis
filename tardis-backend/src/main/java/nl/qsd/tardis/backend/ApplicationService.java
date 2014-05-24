package nl.qsd.tardis.backend;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.qsd.tardis.backend.status.DatabaseHealthCheck;
import nl.qsd.tardis.backend.status.StatusResource;

public class ApplicationService extends Application<TardisConfiguration> {

    public static void main(String[] args) throws Exception {
        System.out.println("ping");
        new ApplicationService().run(args);
    }

	@Override
	public void initialize(
			Bootstrap<TardisConfiguration> bootstrap) {
		GuiceBundle<TardisConfiguration> guiceBundle = GuiceBundle
				.<TardisConfiguration> newBuilder()
				// TODO: add module
				.addModule(new HelloWorldModule())
				.setConfigClass(TardisConfiguration.class).build();

        System.out.println("tardis initialize ");
    }

    @Override
    public void run(TardisConfiguration tardisConfiguration, Environment environment) throws Exception {

        System.out.println("tardis service ");
//        final Thingy thingy = config.getThingyFactory().build();

        environment.jersey().register(new StatusResource());
        environment.jersey().register(new DatabaseHealthCheck());

    }
}
