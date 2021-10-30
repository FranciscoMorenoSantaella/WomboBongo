package model;

import java.util.Objects;

public class Usuarios {
	protected int id;
	protected String nombre;
	protected String contraseña;
	protected String correo;
	protected String foto;

	public Usuarios() {
		id = -1;
		nombre = "noencontrado";
		correo = "noencontrado@noencontrado";
		foto = "noencontrado";
	}

	public Usuarios(String nombre, String correo, String foto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.foto = foto;
	}

	public Usuarios(int id, String nombre, String correo, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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
		Usuarios other = (Usuarios) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", foto=" + foto + "]";
	}

}
