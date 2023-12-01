package route;

import static spark.Spark.exception;

import spark.ExceptionHandler;
import spark.Request;
import spark.Response;
import util.ValidationException;

class ErrorHandler {
	public static void init() {

		exception(ValidationException.class, (ExceptionHandler) (Exception ex, Request request, Response response) -> {
        	response.status(400);
			System.err.println(ex.getMessage());
        });
		
        exception(Exception.class, (ExceptionHandler) (Exception ex, Request request, Response response) -> {
        	response.status(500);
			ex.printStackTrace(System.err);
        });
	}
}
