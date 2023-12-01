package util;

public class CreateResponse {
	private int id;
	private String message;

	public CreateResponse(int id, String message) {
		this.setId(id);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
