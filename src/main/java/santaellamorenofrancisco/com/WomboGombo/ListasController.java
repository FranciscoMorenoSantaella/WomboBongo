package santaellamorenofrancisco.com.WomboGombo;

import java.util.List;


import DAOImp.ListaRPDAOImp;
import DAOImp.UsuariosDAOImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ListaRP;
import model.UserHolder;

public class ListasController {

	@FXML
	private TextField nombre;

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
	private Button crearB;

	@FXML
	private Button borrarB;

	@FXML
	private Button subscribirmeB;
	UserHolder holder = UserHolder.getInstance();
	UsuariosDAOImp us1 = holder.getUser();
	ObservableList<ListaRP> lrp2 = FXCollections.observableArrayList(us1.mostrarMisListas());

	@FXML
	public void initialize() {

		System.out.println(lrp2);

		if (lrp2 != null) {

			t1.setCellValueFactory(new PropertyValueFactory<ListaRP, String>("nombre"));
			t2.setCellValueFactory(new PropertyValueFactory<ListaRP, String>("Descripcion"));
			ObservableList<ListaRP> olrp2 = FXCollections.observableArrayList(lrp2);
			tv1.setItems(olrp2);
		}

		t3.setCellValueFactory(new PropertyValueFactory<ListaRP, String>("nombre"));

		t4.setCellValueFactory(new PropertyValueFactory<ListaRP, String>("descripcion"));
		ListaRPDAOImp lrp = new ListaRPDAOImp();
		ObservableList<ListaRP> olrp = FXCollections.observableArrayList(lrp.mostrarTodos());
		tv2.setItems(olrp);

	}

	public void crearListas() {
		ListaRPDAOImp lrp = new ListaRPDAOImp();
		lrp.setNombre(nombre.getText());
		lrp.setDescripcion(descripcion.getText());
		if (nombre.getText()=="" || descripcion.getText()=="") {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Lista no creada, introduce el nombre y la descripcion por favor");
			alert.showAndWait();
		} else {
			lrp.guardar();
			us1.añadirlistadelusuario(us1, lrp);
			lrp2.add(lrp);
			tv1.setItems(lrp2);

		}

	}
	
	public void borrarLista() {
	
		if (nombre.getText() == "") {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("No has introducido ninguna lista");
			alert.showAndWait();
		} else {
			ListaRPDAOImp lrp = new ListaRPDAOImp();
			System.out.println(t1.getText());
			
			
			lrp = (ListaRPDAOImp) lrp.mostrarPorNombre(nombre.getText());
			System.out.println(lrp);
			us1.borrarlistadelusuario(lrp);
			
		}

	}


}