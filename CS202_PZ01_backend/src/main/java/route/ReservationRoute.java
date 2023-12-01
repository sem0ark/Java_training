package route;

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;

import database.DatabaseConnector;
import database.Performance;
import database.Reservation;
import database.User;

import spark.Request;
import spark.Response;

import util.CreateResponse;
import util.Message;
import util.ValidationException;


class ReservationRoute {
	private static final String prefix = "/reservations";
	
	public static void init(DatabaseConnector conn) {
		Gson gson = new Gson();
		
		
		
		post(prefix, (Request request, Response response) -> {
			String userId = request.queryParams("user");
            User user = conn.getUserDao().queryForId(userId);
            if(user == null) throw new ValidationException("User with id: '" + userId + "' doesn't exist");
            
            String performanceId = request.queryParams("performance");
            Performance performance = conn.getPerformanceDao().queryForId(performanceId);
            if(performance == null) throw new ValidationException("Performance with id: '" + performanceId + "' doesn't exist");
			
            
            int seats;
            try {
            	seats = Integer.parseInt(request.queryParams("seats"));	
			} catch (NumberFormatException e) {
				throw new ValidationException("Failed to parse query params");
			}
            
            Reservation reservation = new Reservation(performance, user, seats);
            conn.getReservationDao().create(reservation);
            
            response.status(201);
            response.type("application/json");
            return new CreateResponse(reservation.getId(), "Reservation created");
        }, gson::toJson);
        
		
		
		get(prefix + "/users/:id", (Request request, Response response) -> {			
        	int userId;
            try {
            	userId = Integer.parseInt(request.params(":id"));	
			} catch (NumberFormatException e) {
				throw new ValidationException("Failed to parse query params");
			}
            
            response.status(200);
            response.type("application/json");
            return Reservation.queryFindByUser(conn, userId);
        }, gson::toJson);
        
		
		
        get(prefix + "/:id", (Request request, Response response) -> {
        	Reservation reservation = conn.getReservationDao().queryForId(request.params(":id"));
			
			if (reservation != null) {
				response.status(200);
				response.type("application/json");
				return reservation;
			} else {
				response.status(404);
				return new Message("User not found");
			}
        }, gson::toJson);
        
        
        
        get(prefix, (Request request, Response response) -> {
        	response.status(200);
			response.type("application/json");
			return conn.getReservationDao().queryForAll().toArray();
        }, gson::toJson);
	}
}
