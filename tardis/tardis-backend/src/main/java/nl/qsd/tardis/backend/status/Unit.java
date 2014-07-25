package nl.qsd.tardis.backend.status;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Unit {

    private Long id;
    private String name;
    private String description;
    private UnitState state;
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
