package nl.qsd.tardis.backend.meta;

import io.dropwizard.jersey.caching.CacheControl;

import java.util.Arrays;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/meta")
@Produces(MediaType.APPLICATION_JSON)
public class MetaRestService implements Meta {

    @GET
    @Path("/profiles")
    @CacheControl(noCache = true)
    @Override
    public Collection<Profile> profiles() {
    	return Arrays.asList(Profile.values());
    }

}
