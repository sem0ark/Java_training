module CS202_DZ11_V2 {
	requires javafx.controls;
	requires org.jsoup;
	
	opens application to javafx.graphics, javafx.fxml;
}
