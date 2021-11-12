package DAO;

import java.util.List;

import DAOImp.CancionesDAOImp;
import DAOImp.UsuariosDAOImp;
import model.Canciones;
import model.ListaRP;
import model.Usuarios;

public interface ListaRPDAO extends IDAO<ListaRP>{
	List<UsuariosDAOImp> mostrarUsuariosSubscritos();
	int contarUsuariosSubscritos();
	List<CancionesDAOImp> mostrasCancionesDeLaLista();
	void añadirCancionesALaLista(ListaRP lrp, Canciones can);
	
}
