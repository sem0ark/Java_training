package com;

import static spark.Spark.port;

import database.DatabaseConnector;
import route.RouteInitiator;

public class Main {
    public static void main(String[] args) {
    	port(3000); // select port to run on
    	DatabaseConnector conn = new DatabaseConnector();
    	RouteInitiator.init(conn);
    }
}