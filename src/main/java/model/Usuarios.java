package model;

import java.util.List;
import java.util.Objects;

public class Usuarios {
	protected int id;
	protected String nombre;
	protected String contraseña;
	protected String correo;
	protected String foto;
	protected List<ListaRP> lrp;

	public Usuarios() {
		id = -1;
		nombre = "noencontrado";
		contraseña = "";
		correo = "noencontrado@noencontrado";
		foto = "noencontrado";
	}

	public Usuarios(String nombre, String contraseña, String correo, String foto, List<ListaRP> lrp) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.correo = correo;
		this.foto = foto;
		this.lrp = lrp;
	}

	public Usuarios(int id, String nombre, String contraseña, String correo, String foto, List<ListaRP> lrp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.correo = correo;
		this.foto = foto;
		this.lrp = lrp;
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

	private String getContraseña() {
		return contraseña;
	}

	private void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<ListaRP> getLrp() {
		return lrp;
	}

	public void setLrp(List<ListaRP> lrp) {
		this.lrp = lrp;
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
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", contraseña=" + contraseña + ", correo=" + correo
				+ ", foto=" + foto + ", lrp=" + lrp + "]";
	}

	
}
