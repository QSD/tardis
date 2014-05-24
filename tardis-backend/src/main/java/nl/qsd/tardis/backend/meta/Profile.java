package nl.qsd.tardis.backend.meta;

public enum Profile {

	PLAIN_TEXT("Plain text"),
	TRAFFIC_LIGHT("Traffic light");

	private String name;
	
	private Profile(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
