module CS202_PZ01_frontend_app {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
