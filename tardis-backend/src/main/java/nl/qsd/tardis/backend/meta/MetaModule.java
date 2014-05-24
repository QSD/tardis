package nl.qsd.tardis.backend.meta;

import com.google.inject.AbstractModule;

public class MetaModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Meta.class).to(MetaRestService.class);
    }
}
