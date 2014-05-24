package nl.qsd.tardis.backend;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.google.inject.AbstractModule;
import com.hubspot.dropwizard.guice.GuiceBundle;

public class ApplicationService extends Application<TardisConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TardisConfiguration> bootstrap) {
        GuiceBundle<TardisConfiguration> guiceBundle = GuiceBundle.<TardisConfiguration>newBuilder()
                // No specific module needed, will auto detect them.
        		.addModule(new AbstractModule() {
                	@Override
                	protected void configure() {
                	}
                })
                .enableAutoConfig("nl.qsd.tardis")
                .setConfigClass(TardisConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(TardisConfiguration tardisConfiguration, Environment environment) throws Exception {
    }
}
