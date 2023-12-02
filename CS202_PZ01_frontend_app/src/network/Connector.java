package network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import data_classes.Performance;
import data_classes.User;

public class Connector {
	HttpClient client;
	Gson gson;
	
	public Connector() {
		this.client = HttpClient.newHttpClient();
		this.gson = new Gson();
	}
	
	
	// NOTE: for some reason wsan't working well with the parser
	//       had to place the snippet directly into the code
	@SuppressWarnings("unused")
	private static <T> Type listOf() {
		return new TypeToken<ArrayList<T>>(){}.getType();
	}

	private interface Requester<T> {
		public T request() throws URISyntaxException, InterruptedException, IOException;
	}
	
	public static <T> T handleErrors(Requester<T> r) {
		try {
			return r.request();  
		} catch (URISyntaxException e) {
			System.err.println("Failed parsing URI");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println("Connection was interrupted");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Connection failed");
			e.printStackTrace();
		}
	
		return null;
	} 
	
	public User getUser(int id) {
		String urlString = "http://localhost:3000/users/" + id;
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString).initRequest().GET().build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			
			return gson.fromJson(response.body(), User.class);
		});
	}
	
	public Performance getPerformance(int id) {
		String urlString = "http://localhost:3000/performances/" + id;
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString).initRequest().GET().build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			
			return gson.fromJson(response.body(), Performance.class);
		});
	}
	
	public List<User> getUsers() {
		String urlString = "http://localhost:3000/users";
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString).initRequest().GET().build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return gson.fromJson(response.body(), new TypeToken<ArrayList<User>>(){}.getType());  
		});
	}
	
	public List<Performance> getPerformances() {
		String urlString = "http://localhost:3000/performances";
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString).initRequest().GET().build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return gson.fromJson(response.body(), new TypeToken<ArrayList<Performance>>(){}.getType());  
		});
	}
}
