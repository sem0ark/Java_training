package route;

import database.DatabaseConnector;


public class RouteInitiator {
	public static void init(DatabaseConnector conn) {
		UserRoute.init(conn);
		PerformanceRoute.init(conn);
	}
}
