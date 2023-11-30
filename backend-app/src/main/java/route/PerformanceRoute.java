package route;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.Date;

import com.google.gson.Gson;

import database.DatabaseConnector;
import database.Performance;
import spark.Request;
import spark.Response;
import util.CreateResponse;
import util.Message;
import util.Util;

public class PerformanceRoute {
	private static final String prefix = "/performances";
	
	public static void init(DatabaseConnector conn) {
		Gson gson = new Gson();
		
		post(prefix, (Request request, Response response) -> {
            String playName = request.queryParams("play");
            Date date = Util.parseDate(request.queryParams("date"));
            int price = Integer.parseInt(request.queryParams("price"));
     
            Performance performance = new Performance(playName, date, price);
            conn.getPerformanceDao().create(performance);
            
            response.status(201);
            return new CreateResponse(performance.getId(), "Performance created");
        }, gson::toJson);
        
        
        get(prefix + "/:id", (Request request, Response response) -> {
        	Performance perf = conn.getPerformanceDao().queryForId(request.params(":id"));
			
			if (perf != null) {
				return new Message(perf.toString());
			} else {
				response.status(404);
				return new Message("Performance not found");
			}
        }, gson::toJson);
	}
}
