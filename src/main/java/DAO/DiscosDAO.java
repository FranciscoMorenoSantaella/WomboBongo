package DAO;

import java.util.List;

import model.Discos;

public interface DiscosDAO extends IDAO<Discos> {
	Discos mostrarPorNombre(String nombre);
	
	
}
