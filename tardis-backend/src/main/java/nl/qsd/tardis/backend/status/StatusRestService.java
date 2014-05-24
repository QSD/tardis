package nl.qsd.tardis.backend.status;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.caching.CacheControl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatusRestService implements Status {

    static int i;

    @GET
    @Path("/counter")
    @Timed
    @CacheControl(noCache = true)
    public int getCounter() {
        return i++;
    }
}
