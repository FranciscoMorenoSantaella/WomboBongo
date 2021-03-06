package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;

import DAOImp.CancionesDAOImp;
import DAOImp.ListaRPDAOImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.Canciones;
import model.ListaRP;

public class ElegirController {

	@FXML
	private TableView tv1;

	@FXML
	private TableColumn t1;
	@FXML
	private TableColumn<CancionesDAOImp, Integer> t2;
	@FXML
	private ImageView perfilB;
	@FXML
	private ImageView listasB;

	@FXML
	private ImageView cancionesB;

	@FXML
	public void initialize() {

	}

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

		App.setRoot("Cancion");
	}

	@FXML
	private void switchToListas() throws IOException {
		App.setRoot("Listas de reproduccion");
	}

	@FXML
	private void switchToPerfil() throws IOException {
		App.setRoot("Perfil");
	}

}
