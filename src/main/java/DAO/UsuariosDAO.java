package DAO;

import java.util.List;

import model.Usuarios;

public interface UsuariosDAO extends IDAO<Usuarios>{
	List<Usuarios> mostrarPorNombre(String nombre);
	void addUsuario(Usuarios us);
	void borrarUsuario(Usuarios us);

}
