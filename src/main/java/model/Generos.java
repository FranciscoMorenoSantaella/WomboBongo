package model;

import java.util.Objects;

public class Generos {
	protected int id;
	protected String nombre;
	
	public Generos() {
		nombre ="noencontrado";
	}

	public Generos(String nombre) {
		this.nombre = nombre;
	}

	public Generos(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Generos other = (Generos) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Generos [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
	
}
