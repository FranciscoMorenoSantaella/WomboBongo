package DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.ListaRPDAO;
import Utils.Conexion;
import model.Artistas;
import model.Canciones;
import model.Discos;
import model.Generos;
import model.ListaRP;
import model.Usuarios;

public class ListaRPDAOImp extends ListaRP implements ListaRPDAO {
	private static final String MOSTRARTODOS = "SELECT id,nombre,descripcion FROM listarp";
	private static final String AÑADIRLISTARP = "INSERT INTO listarp (nombre,descripcion) VALUES (?,?)";
	private static final String BORRARLISTARP = "DELETE FROM listarp WHERE listarp.id = ?";
	private static final String EDITARLISTARP = "UPDATE listarp set nombre=?,descripcion=? WHERE id=?";
	private static final String MOSTRARPORID = "SELECT id,nombre, descripcion FROM listarp WHERE id=?";
	private static final String MOSTRARPORNOMBRE = "SELECT id,nombre,descripcion FROM listarp WHERE nombre=?";
	private Connection con;
	private boolean persisted = false;
	private List<Usuarios> us;
	private List<Canciones> can;

	public ListaRPDAOImp() {
		super();
	}

	public ListaRPDAOImp(String nombre, String descripcion) {
		super(nombre, descripcion);
	}

	public ListaRPDAOImp(int id, String nombre, String descripcion) {
		super(id, nombre, descripcion);
	}

	public ListaRPDAOImp(String nombre, List<Canciones> can, String descripcion) {
		super(nombre, can, descripcion);
	}

	public ListaRPDAOImp(String nombre, String descripcion, List<Usuarios> us) {
		super(nombre, descripcion, us);
	}

	public ListaRPDAOImp(String nombre, String descripcion, List<Canciones> can, List<Usuarios> us) {
		super(nombre, descripcion, can, us);
	}

	public ListaRPDAOImp(int id, String nombre, String descripcion, List<Canciones> can, List<Usuarios> us) {
		super(id, nombre, descripcion, can, us);
	}

	@Override
	public void guardar() {
		con = Conexion.getConnection();
		if (con != null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(AÑADIRLISTARP, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, this.id);
				ps.setString(2, this.nombre);
				ps.setString(3, this.descripcion);
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					this.id = rs.getInt(1);
				}

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					ps.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

	@Override
	public void editar() {
		con = Conexion.getConnection();
		if (con != null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(EDITARLISTARP);
				ps.setInt(1, this.id);
				ps.setString(2, this.nombre);
				ps.setString(3, this.descripcion);
				ps.setInt(3, this.id);
				ps.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					ps.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

	@Override
	public void borrar() {
		con = Conexion.getConnection();

		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(BORRARLISTARP);
				ps.setInt(1, this.id);
				ps.executeUpdate();
				this.id = -1;

				ps.executeUpdate();

			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					ps.close();
					rs.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

	@Override
	public List<ListaRP> mostrarTodos() {
		List<ListaRP> resultado = new ArrayList<ListaRP>();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARTODOS);
				rs = ps.executeQuery();
				while (rs.next()) {
					resultado.add(new ListaRP(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion")));
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					ps.close();
					rs.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		return resultado;
	}

	public ListaRP mostrarPorId(int id) {
		ListaRP resultado = new ListaRPDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORID);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					resultado = (new ListaRPDAOImp(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion")));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return resultado;
	}

	@Override
	public ListaRP mostrarPorNombre(String nombre) {
		ListaRP resultado = new ListaRPDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORNOMBRE);
				ps.setString(1, nombre);
				rs = ps.executeQuery();
				if (rs.next()) {
					resultado = (new ListaRPDAOImp(rs.getInt("id"),rs.getString("nombre"),rs.getString("descripcion")));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return resultado;
	}

}
