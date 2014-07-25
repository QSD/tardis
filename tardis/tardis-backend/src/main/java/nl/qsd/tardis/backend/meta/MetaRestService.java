package nl.qsd.tardis.backend.meta;

import io.dropwizard.jersey.caching.CacheControl;

import java.util.Arrays;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nl.qsd.tardis.backend.TardisRestService;
import nl.qsd.tardis.backend.status.StatusModule;

import com.google.inject.Inject;

@Path("/meta")
@Produces(MediaType.APPLICATION_JSON)
public class MetaRestService implements Meta, TardisRestService {

	@Inject
	private MetaModule metaModule;

	@Inject
	private StatusModule statusModule;

	@Override
	public Collection<Profile> getProfiles() {
		return Arrays.asList(Profile.PLAIN_TEXT);
	}

    @GET
    @Path("/profiles")
    @CacheControl(noCache = true)
    @Override
    public Collection<Profile> profiles() {
    	return Arrays.asList(Profile.values());
    }

    @GET
    @Path("/modules")
    @CacheControl(noCache = true)
    @Override
    public Collection<Module> modules() {
    	//TODO: Find a dynamic way to detect all available modules.
    	return Arrays.asList((Module) metaModule, (Module) statusModule);
    }

}
