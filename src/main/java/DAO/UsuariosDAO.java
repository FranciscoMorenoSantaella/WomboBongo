package DAO;

import java.util.List;

import model.ListaRP;
import model.Usuarios;

public interface UsuariosDAO extends IDAO<Usuarios>{
	void añadirlistadelusuario(Usuarios us, ListaRP lrp);
	void borrarlistadelusuario(ListaRP lrp);

}
