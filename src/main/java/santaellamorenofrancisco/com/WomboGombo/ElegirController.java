package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;

import DAOImp.CancionesDAOImp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ElegirController {

	@FXML
	TextField BuscarCancion;

	@FXML
	private Button canAleB;
	@FXML
	private Button listasB;

	CancionesDAOImp can;

	@FXML
	private void switchToCancion() throws IOException {
		CancionesDAOImp can = new CancionesDAOImp();
		can = (CancionesDAOImp) can.cancionAleatoria();
		if (can.getNombre() == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No hay canciones en la base de datos");
			alert.showAndWait();
		}
		setCancion(can);
		App.setRoot("Cancion");
	}

	@FXML
	private void switchToListas() throws IOException {
		App.setRoot("Listas de reproduccion");
	}

	@FXML
	private void setCancion(CancionesDAOImp can) {
		this.can = can;
	}

}
