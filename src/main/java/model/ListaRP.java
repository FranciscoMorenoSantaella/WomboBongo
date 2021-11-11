package model;

import java.util.List;
import java.util.Objects;

public class ListaRP {
	protected int id;
	protected String nombre;
	protected String descripcion;
	protected List<Canciones> milistadecanciones;
	protected List<Usuarios> milistadeusuarios;

	public ListaRP() {

	}

	public ListaRP(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public ListaRP(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	

	public ListaRP(String nombre, String descripcion, List<Usuarios> milistadeusuarios) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.milistadeusuarios = milistadeusuarios;
	}
	
	public ListaRP(String nombre, List<Canciones> canciones,String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.milistadecanciones = canciones;
	}

	public ListaRP(String nombre, String descripcion, List<Canciones> milistadecanciones,
			List<Usuarios> milistadeusuarios) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.milistadecanciones = milistadecanciones;
		this.milistadeusuarios = milistadeusuarios;
	}

	public ListaRP(int id, String nombre, String descripcion, List<Canciones> milistadecanciones,
			List<Usuarios> milistadeusuarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.milistadecanciones = milistadecanciones;
		this.milistadeusuarios = milistadeusuarios;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Canciones> getMilistadecanciones() {
		return milistadecanciones;
	}

	public void setMilistadecanciones(List<Canciones> milistadecanciones) {
		this.milistadecanciones = milistadecanciones;
	}

	public List<Usuarios> getMilistadeusuarios() {
		return milistadeusuarios;
	}

	public void setMilistadeusuarios(List<Usuarios> milistadeusuarios) {
		this.milistadeusuarios = milistadeusuarios;
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
		ListaRP other = (ListaRP) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "ListaRP [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", milistadecanciones="
				+ milistadecanciones + ", milistadeusuarios=" + milistadeusuarios + "]";
	}

}
