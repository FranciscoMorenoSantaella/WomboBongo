package DAO;

import java.util.List;

import model.Artistas;

public interface ArtistasDAO extends IDAO<Artistas> {
	Artistas mostrarPorNombre(String nombre);
}
