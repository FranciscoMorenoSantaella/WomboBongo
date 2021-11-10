package santaellamorenofrancisco.com.WomboGombo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Artistas;
import model.Discos;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import DAOImp.ArtistasDAOImp;
import DAOImp.DiscosDAOImp;
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
    	ArtistasDAOImp ar = new ArtistasDAOImp();
    	
    	ar = (ArtistasDAOImp) ar.mostrarPorNombre("adios");
    	System.out.println(ar);
    	DiscosDAOImp disk =  new DiscosDAOImp();
    	System.out.println(disk.mostrarPorId(15));
    	
    	
    	
        launch();
    }

}