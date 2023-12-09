module CS202_DZ09 {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
