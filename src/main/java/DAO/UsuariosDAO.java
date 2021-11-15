package DAO;

import java.util.List;

import DAOImp.ListaRPDAOImp;
import model.ListaRP;
import model.Usuarios;

public interface UsuariosDAO extends IDAO<Usuarios>{
	void añadirlistadelusuario(Usuarios us, ListaRP lrp);
	void borrarlistadelusuario(ListaRP lrp);
	Boolean UsuarioExiste(String nombre, String contraseña);
	Boolean UsuarioExiste(String nombre);
	List<ListaRPDAOImp> mostrarMisListas();
}
