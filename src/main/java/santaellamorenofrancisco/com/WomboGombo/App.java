package santaellamorenofrancisco.com.WomboGombo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Artistas;
import model.Discos;
import model.Generos;

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
import Utils.Conexion;
import Utils.XMLReader;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;

	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("Login"), 1025, 576);
		stage.setTitle("Login");
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
		/*ArtistasDAOImp ar = new ArtistasDAOImp();

		ar = (ArtistasDAOImp) ar.mostrarPorNombre("adios");
		System.out.println(ar);

		GenerosDAOImp gen = new GenerosDAOImp();
		gen = (GenerosDAOImp) gen.mostrarPorNombre("traca");
		System.out.println(gen);*/
		ArtistasDAOImp ar = new ArtistasDAOImp();
		DiscosDAOImp disk = new DiscosDAOImp();
		GenerosDAOImp gen = new GenerosDAOImp();
		ar = (ArtistasDAOImp) ar.mostrarPorId(1);
		disk = (DiscosDAOImp) disk.mostrarPorId(1);
		gen = (GenerosDAOImp) gen.mostrarPorId(1);
	
		
		
		CancionesDAOImp can = new CancionesDAOImp(4,"al filo",1,1,disk,gen);
		
		
		

		launch();
	}

}