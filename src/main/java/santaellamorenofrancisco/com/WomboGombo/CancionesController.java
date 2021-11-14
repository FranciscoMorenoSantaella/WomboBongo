package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;

import DAOImp.CancionesDAOImp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CancionesController {
	
	@FXML
	private ImageView volver;
	
	@FXML
	private Text autor;
	
	@FXML
	private Text cancion;
	
	@FXML
	private Text duracion;
	
	@FXML
    void initialize() {
		cargarDatos();
		
    }
	
	@FXML
	public void cargarDatos() {
		CancionesDAOImp can = new CancionesDAOImp();
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
	
}
