module CS202_01 {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens cs202_01 to javafx.graphics, javafx.fxml;
}
