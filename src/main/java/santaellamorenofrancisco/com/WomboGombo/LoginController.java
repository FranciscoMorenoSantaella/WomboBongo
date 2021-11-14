package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import DAOImp.UsuariosDAOImp;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.UserHolder;

public class LoginController extends App {

	@FXML
	private AnchorPane rootPane;
	@FXML
	private TextField txtUser;
	@FXML
	private PasswordField txtPass;

	@FXML
	private Button logB;

	@FXML
	private Button singB;

	private static Scene scene;

	@FXML
	public void initialize() {

	}

	/*
	 * Este metodo comprueba si un usuario existe y si existe inicia sesion en el
	 * programa (Nos lleva a la ventana Game)
	 */
	@FXML
	public void logUser() throws IOException {
		String nombre = this.txtUser.getText();
		String contraseña = this.txtPass.getText();
		UsuariosDAOImp us1 = new UsuariosDAOImp();
		UserHolder holder = UserHolder.getInstance();
		if (us1.UsuarioExiste(nombre, contraseña) == true) {
			us1 = (UsuariosDAOImp) us1.mostrarPorNombre(nombre);
			holder.setUserDAO(us1);
			switchToList();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Uno de los datos introducidos no es valido");
			alert.showAndWait();
		}
	}

	/*
	 * Es un metodo que cambia a la ventana de Registro
	 */
	@FXML
	private void switchToRegistro() throws IOException {
		App.setRoot("Registro");
	}
	
	/*
	 * Es un metodo que cambia a la ventana Game
	 */
	@FXML
	private void switchToList() throws IOException {
		App.setRoot("Elegir");
	}

}