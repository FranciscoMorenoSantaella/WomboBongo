package santaellamorenofrancisco.com.WomboGombo;

import java.io.IOException;
import java.util.List;

import DAOImp.CancionesDAOImp;
import DAOImp.DiscosDAOImp;
import DAOImp.GenerosDAOImp;
import DAOImp.ListaRPDAOImp;
import DAOImp.UsuariosDAOImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Canciones;
import model.Discos;
import model.Generos;
import model.ListaRP;
import model.UserHolder;
import model.Usuarios;

public class ListasController {

	@FXML
	private MenuButton mb;

	@FXML
	private TextField generocan;
	@FXML
	private TableView<Generos> tv4;

	@FXML
	private MenuItem m1;

	@FXML
	private MenuItem m2;

	@FXML
	private Button nuevacancion;

	@FXML
	private TextField nombrecan;

	@FXML
	private TextField duracioncan;

	@FXML
	private Button volver1;

	@FXML
	private Button volver2;

	@FXML
	private TextField nombre;

	@FXML
	private TextField sus;

	@FXML
	private TextField descripcion;

	@FXML
	private TableView<ListaRP> tv1;

	@FXML
	private TableView<ListaRP> tv2;

	@FXML
	private TableColumn<ListaRP, String> t1;

	@FXML
	private TableColumn t2;

	@FXML
	private TableColumn t3;

	@FXML
	private TableColumn t4;

	@FXML
	private TableColumn t5;

	@FXML
	private TableColumn t6;

	@FXML
	private Button crearB;

	@FXML
	private Button borrarB;

	@FXML
	private Button subscribirmeB;
	UserHolder holder = UserHolder.getInstance();
	UsuariosDAOImp us1 = holder.getUser();
	ListaRPDAOImp lrp = new ListaRPDAOImp();
	ObservableList<ListaRP> lrp2 = FXCollections.observableArrayList(us1.mostrarMisListas());
	ObservableList<ListaRP> olrp = FXCollections.observableArrayList(lrp.mostrarTodos());

	@FXML
	public void initialize() {

		if (lrp2 != null) {

			t1.setCellValueFactory(new PropertyValueFactory<ListaRP, String>("nombre"));
			t2.setCellValueFactory(new PropertyValueFactory<ListaRP, Integer>("Descripcion"));
			ObservableList<ListaRP> olrp2 = FXCollections.observableArrayList(lrp2);
			tv1.setItems(olrp2);
		}
		GenerosDAOImp gen = new GenerosDAOImp();
		ObservableList<Generos> genlist = FXCollections.observableArrayList(gen.mostrarTodos());

		System.out.println(genlist);
		t5.setCellValueFactory(new PropertyValueFactory<Generos, String>("nombre"));
		tv4.setItems(genlist);

		CancionesDAOImp canvacio = new CancionesDAOImp();
		List<Canciones> lista = canvacio.mostrarTodos();

		t3.setCellValueFactory(new PropertyValueFactory<ListaRP, String>("nombre"));

		t4.setCellValueFactory(new PropertyValueFactory<ListaRP, String>("descripcion"));

		ObservableList<ListaRP> olrp = FXCollections.observableArrayList(lrp.mostrarTodos());
		tv2.setItems(olrp);
	}
	
	/*
	 * Crea una lista de reproducción metiendo los datos
	 */

	public void crearListas() {
		ListaRPDAOImp lrp = new ListaRPDAOImp();
		lrp.setNombre(nombre.getText());
		lrp.setDescripcion(descripcion.getText());
		if (nombre.getText() == "" || descripcion.getText() == "") {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Lista no creada, introduce el nombre y la descripcion por favor");
			alert.showAndWait();
		} else {
			lrp.guardar();
			us1.añadirlistadelusuario(us1, lrp);
			lrp2.add(lrp);
			olrp.add(lrp);
			tv1.setItems(lrp2);
			tv2.setItems(olrp);
			nombre.clear();
			descripcion.clear();

		}
	}
	
	/**
	 * Sirve para que un usuario pueda tener una lista que ha creado otra persona
	 */

	@FXML
	public void subscribirme() {
		if (tv2.getSelectionModel().getSelectedItem() != null && tv2.getSelectionModel().getSelectedItem().getNombre()
				.equals(us1.mostrarMiLista(sus.getText()).getNombre())) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No se ha podido subscribir a la lista, posiblemente ya estabas subscrito");
			alert.showAndWait();

		} else {
			ListaRPDAOImp lrp4 = new ListaRPDAOImp();
			ListaRPDAOImp lrp3 = (ListaRPDAOImp) lrp4.mostrarPorId(tv2.getSelectionModel().getSelectedItem().getId());
			us1.añadirlistadelusuario(us1, lrp3);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("Te has subscrito correctamente a la lista: "
					+ tv2.getSelectionModel().getSelectedItem().getNombre());
			alert.showAndWait();
			lrp2.add(lrp3);
			tv1.setItems(lrp2);
		}
	}

	@FXML
	public void seleccionar() {
		if (tv2.getSelectionModel().getSelectedItem() != null) {
			sus.setText(tv2.getSelectionModel().getSelectedItem().getNombre());
		}
	}
	
	/*
	 * Borra la lista al usuario pero lo demas usuarios pueden seguir subscritos a ella
	 */

	public void borrarLista() {
		if (nombre.getText() == "") {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No has introducido ninguna lista");
			alert.showAndWait();
		} else {
			ListaRPDAOImp lrp = new ListaRPDAOImp();
			lrp = us1.mostrarMiLista(nombre.getText());
			us1.borrarlistadelusuario(lrp);
			lrp2.remove(lrp);
			tv2.setItems(lrp2);
			nombre.clear();
			descripcion.clear();

		}

	}
	
	/*
	 * Crea una canción (se mete en un disco por defecto)
	 */

	@FXML
	public void crearCancion() {
		if (nombrecan.getText() == "" || duracioncan.getText() == "" || generocan.getText() == "") {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No has introducido alguno de los datos");
			alert.showAndWait();

		} else {
			GenerosDAOImp g = new GenerosDAOImp();
			Generos s = g.mostrarPorNombre(generocan.getText());
			Discos d = new Discos();
			d.setId(1);
			CancionesDAOImp can = new CancionesDAOImp(nombrecan.getText(), Integer.valueOf(duracioncan.getText()), 0, d,
					s);

			can.guardar();
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("Canción creada");
			alert.showAndWait();

		}
	}

	@FXML
	public void seleccionarGenero() {
		if (tv4.getSelectionModel().getSelectedItem() != null) {
			generocan.setText(tv4.getSelectionModel().getSelectedItem().getNombre());
		}
	}

	@FXML
	public void volver() throws IOException {
		App.setRoot("Elegir");
	}

}
