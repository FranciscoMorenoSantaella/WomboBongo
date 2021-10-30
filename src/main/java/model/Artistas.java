package model;

import java.util.Objects;

public class Artistas {
	protected int id;
	protected String nombre;
	protected String nacionalidad;
	protected String foto;

	public Artistas() {
		id = -1;
		nombre = "anonymous";
		nacionalidad = "misteryland";
		foto = "noencontrada.png";
	}

	public Artistas(String nombre, String nacionalidad, String foto) {
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.foto = foto;
	}

	public Artistas(int id, String nombre, String nacionalidad, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.foto = foto;
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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
		Artistas other = (Artistas) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Artistas [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", foto=" + foto + "]";
	}

}

