package route;

import database.DatabaseConnector;


public class RouteLoader {
	public static void init(DatabaseConnector conn) {
		UserRoute.init(conn);
		PerformanceRoute.init(conn);
		
		ErrorHandler.init();
	}
}
