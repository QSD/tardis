package nl.qsd.tardis.backend.status;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.dropwizard.jersey.caching.CacheControl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class StatusRestService implements Status {

    static int i;

    private final Map<Long, Unit> units = Maps.newHashMap();

    public StatusRestService() {
        Unit u1 = new Unit(1L, "Jenkins", "bla bla bla", UnitState.GREEN, new ArrayList<Unit>());
        Unit u2 = new Unit(2L, "LogStash", "bla bla bla", UnitState.GREEN, new ArrayList<Unit>());
        Unit u3 = new Unit(3L, "Jenkins 2", "bla bla bla", UnitState.BLACK, new ArrayList<Unit>());
        Unit u4 = new Unit(4L, "Jenkins 3", "bla bla bla", UnitState.YELLOW, Lists.newArrayList(u1, u2));
        Unit u5 = new Unit(5L, "Jenkins 4", "bla bla bla", UnitState.GREEN, new ArrayList<Unit>());


        units.put(u1.getId(), u1);
        units.put(u2.getId(), u2);
        units.put(u3.getId(), u3);
        units.put(u4.getId(), u4);
        units.put(u5.getId(), u5);
    }

    @GET
    @Path("/counter")
    @Timed
    @CacheControl(noCache = true)
    public int getCounter() {
        return i++;
    }

    @GET
    @Path("/all")
    @Timed
    @CacheControl(noCache = true)
    public List<Unit> getAllUnits() {
        return new ArrayList<>(units.values());
    }

    @GET
    @Path("/{unit}")
    @Timed
    @CacheControl(noCache = true)
    public Unit getUnit(@PathParam("unit") long unit) {
        return units.get(unit);
    }


}
