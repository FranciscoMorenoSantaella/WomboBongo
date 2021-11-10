package DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.GenerosDAO;
import Utils.Conexion;
import model.Artistas;
import model.Discos;
import model.Generos;

public class GenerosDAOImp extends Generos implements GenerosDAO {
	private static final String MOSTRARTODOS = "SELECT id,nombre FROM generos";
	private static final String AÑADIRGENEROS = "INSERT INTO generos (id,nombre) VALUES (?,?)";
	private static final String BORRARGENEROS = "DELETE FROM generos WHERE generos.id =?";
	private static final String EDITARGENEROS = "UPDATE generos set nombre=? WHERE id=?";
	private static final String MOSTRARPORID = "SELECT id,nombre FROM generos WHERE id=?";
	private static final String MOSTRARPORNOMBRE = "SELECT id,nombre FROM generos WHERE nombre=?";
	private Connection con;
	private boolean persisted = false;

	public GenerosDAOImp() {

	}

	public GenerosDAOImp(String nombre) {
		super(nombre);

	}

	public GenerosDAOImp(int id, String nombre) {
		super(id, nombre);

	}

	@Override
	public void guardar() {
		con = Conexion.getConnection();

		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(AÑADIRGENEROS, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, id);
				ps.setString(2, this.nombre);
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
				ps = con.prepareStatement(EDITARGENEROS);
				ps.setString(1, this.nombre);
				ps.setInt(2, this.id);
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
				ps = con.prepareStatement(BORRARGENEROS);
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
	public List<Generos> mostrarTodos() {
		List<Generos> resultado = new ArrayList<Generos>();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARTODOS);
				rs = ps.executeQuery();
				while (rs.next()) {
					resultado.add(new Generos(rs.getInt("id"), rs.getString("nombre")));
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

	@Override
	public Generos mostrarPorId(int id) {
		Generos gen = new GenerosDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORID);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					gen = (new GenerosDAOImp(rs.getInt("id"), rs.getString("nombre")));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return gen;
	}

	@Override
	public Generos mostrarPorNombre(String nombre) {
		Generos resultado = new GenerosDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement(MOSTRARPORNOMBRE);
				ps.setString(1, nombre);
				rs = ps.executeQuery();
				if (rs.next()) {
					resultado = (new GenerosDAOImp(rs.getInt("id"), rs.getString("nombre")));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return resultado;
	}

}
