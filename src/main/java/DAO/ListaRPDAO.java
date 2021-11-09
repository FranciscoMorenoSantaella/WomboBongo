package DAO;

import java.util.List;

import model.ListaRP;

public interface ListaRPDAO extends IDAO<ListaRP>{
	List<ListaRP> mostrarporNombre();
	void addListaRP(ListaRP lrp);
	void borrarListaRP(ListaRP lrp);

}
