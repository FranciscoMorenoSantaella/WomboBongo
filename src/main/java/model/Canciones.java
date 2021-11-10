package model;

import java.util.Objects;

public class Canciones {
	protected int id;
	protected String nombre;
	protected int duracion;
	protected int nReproducciones;
	protected Discos disk;
	protected Generos gen;

	public Canciones() {
		id = -1;
		nombre = "noencontrado";
		duracion = 0;
		nReproducciones = 0;

	}

	public Canciones(String nombre, int duracion, int nReproducciones, Discos disk, Generos gen) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.nReproducciones = nReproducciones;
		this.disk = disk;
		this.gen = gen;
	}

	public Canciones(int id, String nombre, int duracion, int nReproducciones, Discos disk, Generos gen) {
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.nReproducciones = nReproducciones;
		this.disk = disk;
		this.gen = gen;
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getnReproducciones() {
		return nReproducciones;
	}

	public void setnReproducciones(int nReproducciones) {
		this.nReproducciones = nReproducciones;
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
		Canciones other = (Canciones) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Canciones [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", nReproducciones="
				+ nReproducciones + "]";
	}

}
