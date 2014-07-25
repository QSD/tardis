package nl.qsd.tardis.backend.meta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public interface Module {

	@JsonSerialize
	public String getName();

}
