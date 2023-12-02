package network;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connector {
	HttpClient client;
	
	public Connector() {
		this.client = HttpClient.newHttpClient();
	}
	
	
	public String getUsers() {
		HttpRequest request;
		try {
			request = new Request("http://localhost:3000/users").initRequest().GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (URISyntaxException e) {
			System.err.println("Failed parsing URI");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Connection failed");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("Connection was interrupted");
			e.printStackTrace();
		}
		
		return "";
	}
}
