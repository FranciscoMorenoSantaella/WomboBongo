package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;

import DAOImp.CancionesDAOImp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CancionesController {
	
	@FXML
	private ImageView volver;
	
	@FXML
	private ImageView sum;
	
	@FXML
	private Text autor;
	
	@FXML
	private Text cancion;
	
	@FXML
	private Text duracion;
	
	CancionesDAOImp can = new CancionesDAOImp();
	@FXML
    void initialize() {
		cargarDatos();
		
    }
	
	@FXML
	public void cargarDatos() {
		
		can = can.cancionAleatoria();
		autor.setText(can.getNombre());
		cancion.setText(can.getDisk().getAr().getNombre());
		duracion.setText(can.getDuracion()+"");
		System.out.println(can);
	}
	
	@FXML
	public void switchToVolver() throws IOException {
		App.setRoot("Elegir");
	}
	
	@FXML
	public void sumarReproduccion() {
		can.setnReproducciones(can.getnReproducciones()+1);
		can.editar();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Info");
		alert.setContentText("Has reproducido la canción, ahora el numero de reproducciones es: "+can.getnReproducciones());
		alert.showAndWait();
	}
	
}
