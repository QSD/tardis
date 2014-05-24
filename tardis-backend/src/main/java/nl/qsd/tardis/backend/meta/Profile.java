package nl.qsd.tardis.backend.meta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Profile {

	PLAIN_TEXT(
			"Plain text",
			"A value of 'just a bunch of text'."
			),
	TRAFFIC_LIGHT(
			"Traffic light",
			"A String value of GREEN, YELLOW or RED."
			);

	private String displayName;
	private String description;

	private Profile(String displayName, String description) {
		this.displayName = displayName;
		this.description = description;
	}

	@JsonSerialize
	public String getName() {
		return this.toString();
	}

	@JsonSerialize
	public String getDisplayName() {
		return displayName;
	}

	@JsonSerialize
	public String getDescription() {
		return description;
	}

}
