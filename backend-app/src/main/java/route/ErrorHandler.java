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
        	System.err.println("Validation error on: " + request.url());
        	System.err.println(ex.getMessage());
        });
		
        exception(Exception.class, (ExceptionHandler) (Exception ex, Request request, Response response) -> {
        	response.status(500);
        	System.err.println("Internal error on: " + request.url());
			ex.printStackTrace(System.err);
        });
	}
}
