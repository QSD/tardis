package nl.qsd.tardis.backend;

import java.util.Collection;

import nl.qsd.tardis.backend.meta.Profile;

public interface TardisRestService {

	//TODO: Do we want to force methods on rest services?
	Collection<Profile> getProfiles();

}
