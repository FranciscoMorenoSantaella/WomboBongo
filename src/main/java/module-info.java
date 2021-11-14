module santaellamorenofrancisco.com.WomboGombo {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml;
	requires java.sql;
	requires mysql.connector.java;
	requires javafx.graphics;
	requires com.jfoenix;

    opens santaellamorenofrancisco.com.WomboGombo to javafx.fxml;
    exports santaellamorenofrancisco.com.WomboGombo;
}
