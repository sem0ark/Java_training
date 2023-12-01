package util;

public class LongMessage extends Message {
	private String description;

	public LongMessage(String message, String description) {
		super(message);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
