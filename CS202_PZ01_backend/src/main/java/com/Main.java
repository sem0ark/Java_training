package com;

import static spark.Spark.port;

import database.DatabaseConnector;
import route.RouteLoader;

/**
 * 
 * @author Arkadii Semenov 5833 SI FIT
 * @description That program is a back-end application for the CS202-PZ01 project task.
 * 				It implements a basic CRUD application with some business logic and usage examples.
 *
 */
public class Main {
    public static void main(String[] args) {
    	port(3000); // select port to run on
    	DatabaseConnector conn = new DatabaseConnector();
    	RouteLoader.init(conn);
    }
}