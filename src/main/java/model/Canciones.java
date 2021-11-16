package model;

import java.util.Objects;

public class Canciones {
	protected int id;
	protected String nombre;
	protected int duracion;
	protected int reproducciones;
	protected Discos disk;
	protected Generos gen;

	public Canciones() {
		id = -1;
		nombre = "noencontrado";
		duracion = 0;
		reproducciones = 0;

	}
	
	public Canciones(String nombre, int duracion, Generos gen) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.reproducciones = reproducciones;
		this.disk = disk;
		this.gen = gen;
	}


	public Canciones(String nombre, int duracion, int reproducciones, Discos disk, Generos gen) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.reproducciones = reproducciones;
		this.disk = disk;
		this.gen = gen;
	}

	public Canciones(int id, String nombre, int duracion, int reproducciones, Discos disk, Generos gen) {
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.reproducciones = reproducciones;
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
		return reproducciones;
	}

	public void setnReproducciones(int nReproducciones) {
		this.reproducciones = nReproducciones;
	}

	public Discos getDisk() {
		return disk;
	}

	public void setDisk(Discos disk) {
		this.disk = disk;
	}

	public Generos getGen() {
		return gen;
	}

	public void setGen(Generos gen) {
		this.gen = gen;
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
		return "Canciones [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", reproducciones="
				+ reproducciones + ", disk=" + disk + ", gen=" + gen + "]";
	}
	

}
