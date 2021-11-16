package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;

import DAOImp.CancionesDAOImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Canciones;
import model.Discos;
import model.Generos;

public class CancionesController {
	
	@FXML
	private ImageView volver;

	@FXML
	private ImageView sum;

	@FXML
	private Button a;

	@FXML
	private ImageView random;

	@FXML
	private TableView<Canciones> tv1;

	@FXML
	private TableColumn<CancionesDAOImp, String> t1;

	@FXML
	private TableColumn t2;

	@FXML
	private TableColumn t3;

	@FXML
	private Text autor;

	@FXML
	private Text cancion;

	@FXML
	private Text duracion;

	CancionesDAOImp can = new CancionesDAOImp();
	ObservableList<Canciones> canlist = FXCollections.observableArrayList(can.mostrarTodos());

	@FXML
	void initialize() {
		cargarDatos();
		t1.setCellValueFactory(new PropertyValueFactory<CancionesDAOImp, String>("nombre"));
		t2.setCellValueFactory(new PropertyValueFactory<Generos, String>("gen"));
		t3.setCellValueFactory(new PropertyValueFactory<Discos, String>("disk"));

		tv1.setItems(canlist);
	}

	@FXML
	public void cargarDatos() {
		can = can.cancionAleatoria();
		autor.setText(can.getDisk().getAr().getNombre());
		cancion.setText(can.getNombre());
		duracion.setText(can.getDuracion() + "");
	}

	@FXML
	public void switchToVolver() throws IOException {
		App.setRoot("Elegir");
	}

	@FXML
	public void pulsa() {
		if (tv1.getSelectionModel().getSelectedItem() != null) {
			cancion.setText(tv1.getSelectionModel().getSelectedItem().getNombre());
			autor.setText(tv1.getSelectionModel().getSelectedItem().getDisk().getAr().getNombre());
			duracion.setText(tv1.getSelectionModel().getSelectedItem().getDuracion() + "");
			can = can.mostrarPorNombre(cancion.getText());
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No has seleccionado ninguna canción");
			alert.showAndWait();
		}
	}

	@FXML
	public void sumarReproduccion() {
		can.setnReproducciones(can.getnReproducciones() + 1);
		can.editar();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Info");
		alert.setContentText(
				"Has reproducido la canción, ahora el numero de reproducciones es: " + can.getnReproducciones());
		alert.showAndWait();
	}

}
