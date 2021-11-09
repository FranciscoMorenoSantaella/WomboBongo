package DAOImp;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.ArtistasDAO;
import Utils.Conexion;
import model.Artistas;

public class ArtistasDAOImp extends Artistas implements ArtistasDAO {

	private static final String MOSTRARTODOS = "SELECT id,nombre,nacionalidad,foto FROM artistas";
	private static final String AÑADIRARTISTA = "INSERT INTO artistas (nombre,nacionalidad,foto) VALUES (?,?,?)";
	private static final String BORRARARTISTA = "DELETE FROM artistas WHERE artistas.id = ?";
	private static final String EDITARARTISTA = "UPDATE artistas set nombre=?, nacionalidad=?, foto=? WHERE id=?";
	private static final String MOSTRARPORID = "SELECT id,nombre,nacionalidad,foto FROM artistas WHERE artistas.id=?";
	private static final String MOSTRARPORNOMBRE = "SELECT id,nombre,nacionalidad,foto FROM artistas WHERE artistas.nombre=?";
	private Connection con;
	private boolean persisted = false;

	public ArtistasDAOImp() {
		super();
	}

	public ArtistasDAOImp(String nombre, String nacionalidad, String foto) {
		super(nombre, nacionalidad, foto);
	}

	public ArtistasDAOImp(int id, String nombre, String nacionalidad, String foto) {
		super(id, nombre, nacionalidad, foto);
	}

	public ArtistasDAOImp(Artistas ar) {
		super(ar.getId(), ar.getNombre(), ar.getNacionalidad(), ar.getFoto());
	}

	@Override
	public void guardar() {
		con = Conexion.getConnection();

		if (con != null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(AÑADIRARTISTA, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, this.nombre);
				ps.setString(2, this.nacionalidad);
				ps.setString(3, this.foto);

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
				ps = con.prepareStatement(EDITARARTISTA);
				ps.setString(1, this.nombre);
				ps.setString(2, this.nacionalidad);
				ps.setString(3, this.foto);
				ps.setInt(4, this.id);
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
				ps = con.prepareStatement(BORRARARTISTA);
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
	public List<Artistas> mostrarTodos() {
		List<Artistas> resultado = new ArrayList<Artistas>();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARTODOS);
				rs = ps.executeQuery();
				while (rs.next()) {
					resultado.add(new Artistas(rs.getInt("id"), rs.getString("nombre"), rs.getString("nacionalidad"),
							rs.getString("foto")));
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

	public Artistas mostrarPorId(int id) {
		Artistas ar = new ArtistasDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORID);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					ar = new ArtistasDAOImp(rs.getInt("id"), rs.getString("nombre"), rs.getString("nacionalidad"),
							rs.getString("foto"));

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ar;
	}

	@Override
	public Artistas mostrarPorNombre(String nombre) {
		Artistas ar = new ArtistasDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement(MOSTRARPORNOMBRE);
				ps.setString(1, nombre);
				rs = ps.executeQuery();
				if (rs.next()) {
					ar = new ArtistasDAOImp(rs.getInt("id"), rs.getString("nombre"), rs.getString("nacionalidad"),
							rs.getString("foto"));

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ar;
	}

}
