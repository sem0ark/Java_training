module CS202_DZ01 {
	requires javafx.controls;
	requires javafx.base;
	
	opens com to javafx.graphics, javafx.fxml;
}
