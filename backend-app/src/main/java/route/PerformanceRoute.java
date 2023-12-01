package route;

import java.util.Date;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.post;
import spark.Request;
import spark.Response;

import database.DatabaseConnector;
import database.Performance;

import util.CreateResponse;
import util.Message;
import util.Util;
import util.ValidationException;

class PerformanceRoute {
	private static final String prefix = "/performances";
	
	public static void init(DatabaseConnector conn) {
		Gson gson = new Gson();
		
		
		
		post(prefix, (Request request, Response response) -> {
			try {
	            String playName = request.queryParams("play");
	            Date date = Util.parseDate(request.queryParams("date"));
	            int price = Integer.parseInt(request.queryParams("price"));
	            

	            Performance performance = new Performance(playName, date, price);
	            conn.getPerformanceDao().create(performance);
	            response.status(201);
	            response.type("application/json");
	            return new CreateResponse(performance.getId(), "Performance created");
	            
			} catch (NumberFormatException | java.text.ParseException e) {
				throw new ValidationException(request.url() + ": Failed to parse query values");
			}
        }, gson::toJson);

        
		
		get(prefix, (Request request, Response response) -> {
        	response.status(200);
            response.type("application/json");
        	return conn.getPerformanceDao().queryForAll().toArray();
        }, gson::toJson);
        
        
        
        get(prefix + "/near", (Request request, Response response) -> {
        	try {
        		int days = Integer.parseInt(request.queryParams("days"));

        		response.status(200);
	            response.type("application/json");
            	return Performance.queryFindNext(conn, days);
        	} catch (NumberFormatException e) {
				throw new ValidationException(request.url() + ": Failed to parse days");
			}
        }, gson::toJson);
        
        
        
		get(prefix + "/:id", (Request request, Response response) -> {
			try {
				Performance perf = conn.getPerformanceDao().queryForId(request.params(":id"));
				
				if (perf != null) {
					response.status(200);
		            response.type("application/json");
					return perf;
				}
			} catch (NumberFormatException e) {
				throw new ValidationException(request.url() + ": Failed to parse query values.");
			}
			
			response.status(404);
			return new Message(request.url() + ": Performance with ID '" + request.params(":id") + "' doesn't exist");
			
        }, gson::toJson);
	}
}
