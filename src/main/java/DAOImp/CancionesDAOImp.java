package DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.CancionesDAO;
import Utils.Conexion;
import model.Artistas;
import model.Canciones;
import model.Discos;
import model.Generos;

public class CancionesDAOImp extends Canciones implements CancionesDAO {
	private static final String MOSTRARTODOS = "SELECT id,nombre,duracion,reproducciones,id_discos,id_generos FROM canciones";
	private static final String AÑADIRCANCIONES = "INSERT INTO canciones (nombre,duracion,reproducciones,id_discos,id_generos,id) VALUES (?,?,?,?,?,?)";
	private static final String BORRARCANCIONES = "DELETE FROM canciones WHERE canciones.id = ?";
	private static final String EDITARCANCIONES = "UPDATE canciones set nombre=?, duracion=?, reproducciones=?, id_discos=?,id_generos=? WHERE id=?";
	private static final String MOSTRARPORID = "SELECT id,nombre,duracion,reproducciones,id_discos,id_generos FROM canciones WHERE canciones.id=?";
	private static final String MOSTRARPORNOMBRE = "SELECT id,nombre,duracion,reproducciones,id_discos,id_generos FROM canciones WHERE canciones.nombre=?";
	private static final String CANCIONALEATORIA = " SELECT * FROM canciones ORDER BY rand() LIMIT 1";
	private Connection con;
	private boolean persisted = false;

	public CancionesDAOImp() {
		super();
	}

	public CancionesDAOImp(String nombre, int duracion, int reproducciones, Discos disk, Generos gen) {
		super(nombre, duracion, reproducciones, disk, gen);
	}

	public CancionesDAOImp(int id, String nombre, int duracion, int reproducciones, Discos disk, Generos gen) {
		super(id, nombre, duracion, reproducciones, disk, gen);
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
				ps.setInt(3, this.reproducciones);
				ps.setObject(4, this.disk.getId());
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
				ps.setInt(3, this.reproducciones);
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
	public List<Canciones> mostrarTodos() {
		List<Canciones> resultado = new ArrayList<Canciones>();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARTODOS);
				rs = ps.executeQuery();
				while (rs.next()) {
					DiscosDAOImp disk = new DiscosDAOImp();
					Discos disk1 = disk.mostrarPorId(rs.getInt("id_discos"));
					GenerosDAOImp gen = new GenerosDAOImp();
					Generos gen1 = gen.mostrarPorId(rs.getInt("id_generos"));
					resultado.add(new Canciones(rs.getInt("id"), rs.getString("nombre"), rs.getInt("duracion"),
							rs.getInt("reproducciones"), disk1, gen1));

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
	public Canciones mostrarPorId(int id) {
		Canciones resultado = new CancionesDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;

			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORID);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					DiscosDAOImp disk = new DiscosDAOImp();
					Discos disk1 = disk.mostrarPorId(rs.getInt("id_discos"));
					GenerosDAOImp gen = new GenerosDAOImp();
					Generos gen1 = gen.mostrarPorId(rs.getInt("id_generos"));
					resultado = (new Canciones(rs.getInt("id"), rs.getString("nombre"), rs.getInt("duracion"),
							rs.getInt("reproducciones"), disk1, gen1));

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
	public CancionesDAOImp mostrarPorNombre(String nombre) {
		CancionesDAOImp resultado = new CancionesDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;

			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORNOMBRE);
				ps.setString(1, nombre);
				rs = ps.executeQuery();
				if (rs.next()) {
					DiscosDAOImp disk = new DiscosDAOImp();
					Discos disk1 = disk.mostrarPorId(rs.getInt("id_discos"));
					GenerosDAOImp gen = new GenerosDAOImp();
					Generos gen1 = gen.mostrarPorId(rs.getInt("id_generos"));
					resultado = (new CancionesDAOImp(rs.getInt("id"), rs.getString("nombre"), rs.getInt("duracion"),
							rs.getInt("reproducciones"), disk1, gen1));

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
	public CancionesDAOImp cancionAleatoria() {
		CancionesDAOImp resultado = new CancionesDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;

			ResultSet rs = null;
			try {
				ps = con.prepareStatement(CANCIONALEATORIA);
				rs = ps.executeQuery();
				if (rs.next()) {
					DiscosDAOImp disk = new DiscosDAOImp();
					Discos disk1 = disk.mostrarPorId(rs.getInt("id_discos"));
					GenerosDAOImp gen = new GenerosDAOImp();
					Generos gen1 = gen.mostrarPorId(rs.getInt("id_generos"));
					resultado = (new CancionesDAOImp(rs.getInt("id"), rs.getString("nombre"), rs.getInt("duracion"),
							rs.getInt("reproducciones"), disk1, gen1));

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


}
