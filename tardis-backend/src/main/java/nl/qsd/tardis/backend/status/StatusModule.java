package nl.qsd.tardis.backend.status;

import nl.qsd.tardis.backend.meta.Module;

import com.google.inject.AbstractModule;

public class StatusModule extends AbstractModule implements Module {

	@Override
	public String getName() {
		return "Status";
	}

	@Override
    protected void configure() {
        bind(Status.class).to(StatusRestService.class);
    }

}
