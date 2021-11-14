package santaellamorenofrancisco.com.WomboGombo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Artistas;
import model.Canciones;
import model.Discos;
import model.Generos;
import model.ListaRP;
import model.Usuarios;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import DAOImp.ArtistasDAOImp;
import DAOImp.CancionesDAOImp;
import DAOImp.DiscosDAOImp;
import DAOImp.GenerosDAOImp;
import DAOImp.ListaRPDAOImp;
import DAOImp.UsuariosDAOImp;
import Utils.Conexion;
import Utils.XMLReader;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("Login2"), 1024, 576);
		stage.setTitle("WomboBongo");
		stage.setScene(scene);
		stage.show();
	}

	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public static void main(String[] args) {
		UsuariosDAOImp us1 = new UsuariosDAOImp("pana","pana","panasea2");
		launch();
	}

}