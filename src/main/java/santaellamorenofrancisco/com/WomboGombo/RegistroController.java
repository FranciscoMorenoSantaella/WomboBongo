package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;
import java.lang.System.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import DAOImp.UsuariosDAOImp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.UserHolder;

public class RegistroController {

	@FXML
	private Button singB;
	@FXML
	private Button BackL;
	@FXML
	private TextField txtUser;
	@FXML
	private TextField txtEmail;
	@FXML
	private PasswordField txtPass;

	/*
	 * Es un metodo que sirve para registrarnos en la aplicacion, comprueba si un
	 * usuario existe, si existe sale una alerta diciendo que el usuario ya esta en
	 * la base de datos si no existe se guardan los datos en la base de datos.
	 */
	@FXML
	protected void singUser() throws IOException {
		String nombre = this.txtUser.getText();
		String contraseña = this.txtPass.getText();
		String correo = this.txtEmail.getText();
		UsuariosDAOImp us1 = new UsuariosDAOImp(nombre, contraseña, correo);

		if (us1.UsuarioExiste(nombre) == false && validate(correo)) {
		
			us1.guardar();
			UserHolder holder = UserHolder.getInstance();
			holder.setUserDAO(us1);
			
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Elegir.fxml"));
			Parent modal;
			try {
				switchToElegir();

			} catch (IOException ex) {

			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Este usuario ya existe en la base de datos o email invalido");
			alert.showAndWait();
		}
	}


	/*
	 * Cambia a la ventana login
	 */
	@FXML
	private void switchTologin() throws IOException {
		App.setRoot("Login2");
	}

	@FXML
	private void switchToElegir() throws IOException {
		App.setRoot("Elegir");
	}

	/*
	 * Patron para saber si un email es valido
	 */
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	/*
	 * Ha este metodo se le pasa un email para comprobar si es valido
	 */
	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
}
