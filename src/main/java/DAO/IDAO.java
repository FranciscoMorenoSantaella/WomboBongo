package DAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T>{
	// si el dao hereda guardar no recibe nada y si no hereda recibe la otro clase
	void guardar();
	void editar();
	void borrar();
	List<T> mostrarTodos(/*int page*/) throws SQLException;
	T mostrarPorId(int id);

}
