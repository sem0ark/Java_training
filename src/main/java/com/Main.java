package com;

import static spark.Spark.get;
import static spark.Spark.post;

import static spark.Spark.port;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import database.User;
import spark.Request;
import spark.Response;


public class Main {
    public static void main(String[] args) throws SQLException {
    	port(3000); // select port to run on
    	
    	String databaseUrl = "jdbc:mysql://localhost:3306/IT250_V08";
    	 
    	ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
		((JdbcConnectionSource)connectionSource).setUsername("root");
		((JdbcConnectionSource)connectionSource).setPassword("root");
    	
		
		Dao<User, String> userDao = DaoManager.createDao(connectionSource, User.class);
		TableUtils.createTableIfNotExists(connectionSource, User.class);
		

        post("/users", (Request request, Response response) -> {
            String username = request.queryParams("username");
            String email = request.queryParams("email");
     
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            
            userDao.create(user);
            
            response.status(201);
            return "Created with ID: " + user.getId();
        });
        
        get("/users/:id", (Request request, Response response) -> {
			User user = userDao.queryForId(request.params(":id"));
			
			if (user != null) {
				return "Username: " + user.getUsername();
			} else {
				response.status(404);
				return "User not found";
			}
        });
        
        
    }
}