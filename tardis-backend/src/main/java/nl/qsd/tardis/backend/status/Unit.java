package nl.qsd.tardis.backend.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

public class Unit {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private UnitState state;
    @JsonSerialize(contentAs = Unit.class)
    private List<Unit> units;

    public Unit(Long id, String name, String description, UnitState state, List<Unit> units) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.units = units;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UnitState getState() {
        return state;
    }

    public List<Unit> getUnits() {
        return units;
    }
}
