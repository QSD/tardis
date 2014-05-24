package nl.qsd.tardis.backend.status;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.jersey.caching.CacheControl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/status/health")
@Produces(MediaType.APPLICATION_JSON)
public class DatabaseHealthCheckRestService extends HealthCheck implements DatabaseHealthCheck {

    private final Random random = new Random();

    @GET
    @Path("/check")
    @CacheControl(noCache = true)
    @Override
    public Result check() {
        if (random.nextInt(5) % 5 == 1) {
            return Result.unhealthy("Cannot. Is down", "Aap", "Noot");
        } else {
            return Result.healthy();
        }
    }

}
