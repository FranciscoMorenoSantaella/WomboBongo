package DAO;

import java.util.List;

import model.Canciones;

public interface CancionesDAO extends IDAO<Canciones> {
	List<Canciones> mostrarPorNombre(String nombre);
	void addCanciones(Canciones c);
	void borrarCanciones(Canciones c);
}
