package model;

import java.util.List;
import java.util.Objects;

public class ListaRP {
	protected int id;
	protected String nombre;
	protected String descripcion;
	protected List<Canciones> listadecanciones;
	protected List<Usuarios> milistadesubscritores;

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
	

	public ListaRP(String nombre, String descripcion, List<Usuarios> milistadesubscritores) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.milistadesubscritores = milistadesubscritores;
	}
	
	public ListaRP(String nombre, List<Canciones> canciones,String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listadecanciones = canciones;
	}

	public ListaRP(String nombre, String descripcion, List<Canciones> listadecanciones,
			List<Usuarios> milistadesubscritores) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listadecanciones = listadecanciones;
		this.milistadesubscritores = milistadesubscritores;
	}

	public ListaRP(int id, String nombre, String descripcion, List<Canciones> listadecanciones,
			List<Usuarios> milistadesubscritores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listadecanciones = listadecanciones;
		this.milistadesubscritores = milistadesubscritores;
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

	public List<Canciones> getlistadecanciones() {
		return listadecanciones;
	}

	public void setlistadecanciones(List<Canciones> listadecanciones) {
		this.listadecanciones = listadecanciones;
	}

	public List<Usuarios> getmilistadesubscritores() {
		return milistadesubscritores;
	}

	public void setmilistadesubscritores(List<Usuarios> milistadesubscritores) {
		this.milistadesubscritores = milistadesubscritores;
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
		return "ListaRP [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", listadecanciones="
				+ listadecanciones + ", milistadesubscritores=" + milistadesubscritores + "]";
	}

}
