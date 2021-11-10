package DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.CancionesDAO;
import Utils.Conexion;
import model.Canciones;
import model.Discos;
import model.Generos;

public class CancionesDAOImp extends Canciones implements CancionesDAO {
	private static final String MOSTRARTODOS = "SELECT id,nombre,duracion,nReproducciones,id_discos,id_generos FROM canciones";
	private static final String AÑADIRCANCIONES = "INSERT INTO canciones (nombre,duracion,nReproducciones,id_discos,id_generos) VALUES (?,?,?,?,?)";
	private static final String BORRARCANCIONES = "DELETE FROM canciones WHERE canciones.id = ?";
	private static final String EDITARCANCIONES = "UPDATE canciones set nombre=?, duracion=?, nReproducciones=?, id_discos=?,id_generos=? WHERE id=?";
	private static final String MOSTRARPORID = "SELECT id,nombre,duracion,nReproducciones,id_discos,id_generos FROM canciones WHERE canciones.id=?";
	private static final String MOSTRARPORNOMBRE = "SELECT id,nombre,duracion,nReproducciones,id_discos,id_generos FROM canciones WHERE canciones.nombre=?";
	private Connection con;
	private boolean persisted = false;

	public CancionesDAOImp() {
		super();
	}

	public CancionesDAOImp(String nombre, int duracion, int nReproducciones, Discos disk, Generos gen) {
		super(nombre, duracion, nReproducciones, disk, gen);
	}

	public CancionesDAOImp(int id, String nombre, int duracion, int nReproducciones, Discos disk, Generos gen) {
		super(id, nombre, duracion, nReproducciones, disk, gen);
	}

	@Override
	public void guardar() {
		con = Conexion.getConnection();
		if (con != null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(AÑADIRCANCIONES, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, this.nombre);
				ps.setInt(2, this.duracion); // Para convertir LocalDate al formato DATE
				ps.setInt(3, this.nReproducciones);
				ps.setObject(4, this.disk.getId() );
				ps.setObject(5, this.gen.getId());
				ps.setInt(6, this.id);
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
				ps = con.prepareStatement(EDITARCANCIONES);
				ps.setString(1, this.nombre);
				ps.setInt(2, this.duracion);
				ps.setInt(3, this.nReproducciones);
				ps.setObject(4, this.disk.getId());
				ps.setObject(5, this.gen.getId());
				ps.setInt(6, this.id);
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
				ps = con.prepareStatement(BORRARCANCIONES);
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
	public List<Canciones> mostrarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Canciones mostrarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Canciones mostrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
