module santaellamorenofrancisco.com.WomboGombo {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml;
	requires java.sql;
	requires javafx.base;
	requires mysql.connector.java;
	requires javafx.graphics;
	requires com.jfoenix;

    opens santaellamorenofrancisco.com.WomboGombo to javafx.graphics, javafx.fxml, javafx.base;
    opens model to javafx.base;
    exports santaellamorenofrancisco.com.WomboGombo;
}
