package nl.qsd.tardis.backend;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.qsd.tardis.backend.status.StatusModule;
import nl.qsd.tardis.modules.database.DatabaseModule;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.reflections.util.FilterBuilder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class ApplicationService extends Application<TardisConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }

    @Override
    public void initialize(Bootstrap<TardisConfiguration> bootstrap) {
        GuiceBundle<TardisConfiguration> guiceBundle = GuiceBundle.<TardisConfiguration>newBuilder()
                .addModule(new DatabaseModule())
                .addModule(new StatusModule())
                .enableAutoConfig("nl.qsd.tardis")
                .setConfigClass(TardisConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(TardisConfiguration tardisConfiguration, Environment environment) throws Exception {
        environment.servlets()
                .addFilter("Custom-Filter-Name", new CrossOriginFilter())
                .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
//        filterConfig.setInitParam(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
//        filterConfig.setInitParam("Access-Control-Allow-Credentials", "*");
//        filterConfig.setInitParam("Access-Control-Allow-Methods", "*");

    }
}
