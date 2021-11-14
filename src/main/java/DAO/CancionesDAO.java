package DAO;

import java.util.List;

import DAOImp.CancionesDAOImp;
import model.Canciones;

public interface CancionesDAO extends IDAO<Canciones> {
	CancionesDAOImp cancionAleatoria();
}
