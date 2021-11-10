package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Discos {
	protected int id;
	protected String nombre;
	protected String foto;
	protected LocalDate fecha;
	protected Artistas ar;

	public Discos() {

	}

	public Discos(String nombre, String foto, LocalDate fecha, Artistas ar) {
		this.nombre = nombre;
		this.foto = foto;
		this.fecha = fecha;
		this.ar = ar;
	}

	public Discos(int id, String nombre, String foto, LocalDate fecha, Artistas ar) {
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.fecha = fecha;
		this.ar = ar;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Artistas getAr() {
		return ar;
	}

	public void setAr(Artistas ar) {
		this.ar = ar;
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
		Discos other = (Discos) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Discos [id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", fecha=" + fecha + ", ar=" + ar + "]";
	}

}
