package route;

import static spark.Spark.get;
import static spark.Spark.post;

import database.DatabaseConnector;
import database.User;
import spark.Request;
import spark.Response;
import util.CreateResponse;
import util.Message;

import com.google.gson.Gson;

class UserRoute {
	private static final String prefix = "/users";
	
	public static void init(DatabaseConnector conn) {
		Gson gson = new Gson();
		
		post(prefix, (Request request, Response response) -> {
            String username = request.queryParams("username");
            String email = request.queryParams("email");
     
            User user = new User(username, email);
            conn.getUserDao().create(user);
            
            response.status(201);
			response.type("application/json");
            return new CreateResponse(user.getId(), "User created");
        }, gson::toJson);
        
        
        get(prefix + "/:id", (Request request, Response response) -> {
			User user = conn.getUserDao().queryForId(request.params(":id"));
			
			if (user != null) {
				response.status(200);
				response.type("application/json");
				return user;
			} else {
				response.status(404);
				return new Message("User not found");
			}
        }, gson::toJson);
        
        get(prefix, (Request request, Response response) -> {
        	response.status(200);
			response.type("application/json");
			return conn.getUserDao().queryForAll().toArray();
        }, gson::toJson);
	} 
}
