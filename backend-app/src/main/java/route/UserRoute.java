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
	public static void init(DatabaseConnector conn) {
		Gson gson = new Gson();
		
		post("/users", (Request request, Response response) -> {
            String username = request.queryParams("username");
            String email = request.queryParams("email");
     
            User user = new User(username, email);
            conn.getUserDao().create(user);
            
            response.status(201);
            return new CreateResponse(user.getId(), "User created");
        }, gson::toJson);
        
        
        get("/users/:id", (Request request, Response response) -> {
			User user = conn.getUserDao().queryForId(request.params(":id"));
			
			if (user != null) {
				return new Message("Username: " + user.getUsername());
			} else {
				response.status(404);
				return new Message("User not found");
			}
        }, gson::toJson);
	} 
}
