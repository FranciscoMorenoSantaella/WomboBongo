package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;

import DAOImp.UsuariosDAOImp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.UserHolder;

public class PerfilController {
	@FXML
	private TextField txtnombre;
	@FXML
	private TextField txtcorreo;
	@FXML
	private Button volver;
	@FXML
	private Button guardarB;
	
	UserHolder holder = UserHolder.getInstance();
	UsuariosDAOImp us1 = holder.getUser();
	
	@FXML
	public void initialize() {
		txtnombre.setText(us1.getNombre());
		txtcorreo.setText(us1.getCorreo());
	}
	
	@FXML
	public void guardarCambios(){
		us1.setNombre(txtnombre.getText());
		us1.setCorreo(txtcorreo.getText());
		us1.editar();
		holder.setUserDAO(us1);
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Info");
		alert.setContentText("Cambios guardados");
		alert.showAndWait();
	}
	
	@FXML
	public void volver() throws IOException {
		App.setRoot("Elegir");
	}
}
