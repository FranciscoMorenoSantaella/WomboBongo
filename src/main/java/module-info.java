module santaellamorenofrancisco.com.WomboGombo {
    requires javafx.controls;
    requires javafx.fxml;

    opens santaellamorenofrancisco.com.WomboGombo to javafx.fxml;
    exports santaellamorenofrancisco.com.WomboGombo;
}
