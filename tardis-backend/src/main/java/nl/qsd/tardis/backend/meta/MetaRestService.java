package nl.qsd.tardis.backend.meta;

import io.dropwizard.jersey.caching.CacheControl;

import java.util.Arrays;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

@Path("/meta")
@Produces(MediaType.APPLICATION_JSON)
public class MetaRestService implements Meta {

    @GET
    @Path("/profiles")
    @CacheControl(noCache = true)
    @Override
    public Collection<String> profiles() {
    	return Collections2.transform(Arrays.asList(Profile.values()), new Function<Profile, String>() {
    		@Override
    		public String apply(Profile profile) {
    			return profile.getName();
    		}
    	});
    }

}
