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
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import data_classes.Performance;
import data_classes.PostID;
import data_classes.Reservation;
import data_classes.User;
import util.SmallDate;

/**
 * 
 * @author Arkadii
 * @description A facade for interactions between front-end and back-end parts of the project.
 * 				It implements main data request methods to quickly get the required information without worrying about the networking part.  
 *
 */
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
		} catch (JsonSyntaxException e) {
			System.err.println("Failed parcing JSON contents.");
		}
	
		return null;
	}
	
	public Integer addUser(String username, String email) {
		String urlString = "http://localhost:3000/users";
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString).setParams("username", username, "email", email)
					.initRequest().POST(HttpRequest.BodyPublishers.noBody()).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			
			return gson.fromJson(response.body(), PostID.class);
		}).id;
	}
	
	public Integer addPerformance(String playName, SmallDate date, Integer price) {
		String urlString = "http://localhost:3000/perfromances";
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString)
					.setParams("play", playName, "date", date.toString(), "price", price.toString())
					.initRequest().POST(HttpRequest.BodyPublishers.noBody()).build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			
			return gson.fromJson(response.body(), PostID.class);
		}).id;
	}
	
	public Integer addReservation(Integer userId, Integer performanceId, Integer seats) {
		String urlString = "http://localhost:3000/reservations";
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString)
					.setParams("user", userId.toString(), "performance", performanceId.toString(), "seats", seats.toString())
					.initRequest().POST(HttpRequest.BodyPublishers.noBody()).build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			
			return gson.fromJson(response.body(), PostID.class);
		}).id;
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
			System.out.println(response.body());
			return gson.fromJson(response.body(), new TypeToken<ArrayList<Performance>>(){}.getType());  
		});
	}
	
	public Reservation getReservation(int id) {
		String urlString = "http://localhost:3000/reservations/" + id;
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString).initRequest().GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			System.out.println(response.body());
			Reservation r = gson.fromJson(response.body(), Reservation.class);
			r.setName();
			return r;
		});
	}
	
	public List<Reservation> getReservationsByUser(Integer userId) {
		String urlString = "http://localhost:3000/reservations/users/" + userId.toString();
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString).initRequest().GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			System.out.println(response.body());
			ArrayList<Reservation> res = gson.fromJson(response.body(), new TypeToken<ArrayList<Reservation>>(){}.getType());
			for(Reservation r : res) {
				r.setName();
				r.setDate();
			}
			
			return res;
		});
	}
	
	public List<Performance> getPerformances(Integer days) {
		String urlString = "http://localhost:3000/performances/near";
		
		return handleErrors(() -> {
			HttpRequest request = new Request(urlString)
					.setParams("days", days.toString())
					.initRequest().GET().build();
			
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return gson.fromJson(response.body(), new TypeToken<ArrayList<Performance>>(){}.getType());  
		});
	}
}
