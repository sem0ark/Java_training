module CS202_PZ01_frontend_app {
	requires javafx.controls;
	requires java.net.http;
	
	opens application to javafx.graphics, javafx.fxml;
}
