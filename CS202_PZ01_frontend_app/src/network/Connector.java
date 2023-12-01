package network;

import java.net.http.HttpClient;

public class Connector {
	HttpClient client;
	
	public Connector() {
		this.client = HttpClient.newHttpClient();
	}
	
	
	public getUsers() {
		// HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	}
}
