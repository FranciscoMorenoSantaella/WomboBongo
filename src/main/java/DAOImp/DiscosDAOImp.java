package DAOImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DAO.DiscosDAO;
import Utils.Conexion;
import model.Artistas;
import model.Discos;

public class DiscosDAOImp extends Discos implements DiscosDAO {
	private static final String MOSTRARTODOS = "SELECT id,nombre,foto,fecha,id_artistas FROM discos";
	private static final String AÑADIRDISCOS = "INSERT INTO discos (nombre,foto,fecha,id_artistas) VALUES (?,?,?,?)";
	private static final String BORRARDISCOS = "DELETE FROM discos WHERE discos.id = ?";
	private static final String EDITARDISCOS = "UPDATE discos set nombre=?, foto=?, fecha=?, id_artistas=? WHERE id=?";
	private static final String MOSTRARPORID = "SELECT id,nombre,foto,fecha,id_artistas FROM discos WHERE id=?";
	private static final String MOSTRARPORNOMBRE = "SELECT id,nombre,foto,fecha,id_artistas FROM discos WHERE nombre=?";
	private Connection con;
	private boolean persisted = false;
	private Date date;
	private LocalDate ld;

	public DiscosDAOImp() {
		super();
	}

	public DiscosDAOImp(String nombre, String foto, LocalDate fecha, Artistas ar) {
		super(nombre, foto, fecha, ar);

	}

	public DiscosDAOImp(int id, String nombre, String foto, LocalDate fecha, Artistas ar) {
		super(id, nombre, foto, fecha, ar);
	}

	public DiscosDAOImp(Discos disk) {
		super(disk.getId(), disk.getNombre(), disk.getFoto(), disk.getFecha(), disk.getAr());
	}

	@Override
	public void guardar() {
		con = Conexion.getConnection();
		if (con != null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(AÑADIRDISCOS, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, this.nombre);
				ps.setString(2, this.foto); // Para convertir LocalDate al formato DATE
				date = date.valueOf(this.fecha);
				ps.setDate(3, this.date);
				ps.setObject(4, this.ar.getId());
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
				ps = con.prepareStatement(EDITARDISCOS);
				ps.setString(1, this.nombre);
				ps.setString(2, this.foto);
				date = date.valueOf(this.fecha); // Para convertir TimeStap a Date
				ps.setDate(3, this.date);
				ps.setObject(4, this.ar.getId());
				ps.setInt(5, this.id);
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
				ps = con.prepareStatement(BORRARDISCOS);
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
	public List<Discos> mostrarTodos() {
		List<Discos> resultado = new ArrayList<Discos>();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARTODOS);
				rs = ps.executeQuery();
				while (rs.next()) {
					ArtistasDAOImp ar = new ArtistasDAOImp();
					Artistas ar1 = ar.mostrarPorId(rs.getInt("id_artistas"));
					resultado.add(new Discos(rs.getInt("id"), rs.getString("nombre"), rs.getString("foto"),
							rs.getDate("fecha").toLocalDate(), ar1));

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

	public Discos mostrarPorId(int id) {
		Discos resultado = new DiscosDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORID);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					ArtistasDAOImp ar = new ArtistasDAOImp();
					Artistas ar1 = ar.mostrarPorId(rs.getInt("id_artistas"));
					resultado = (new DiscosDAOImp(rs.getInt("id"), rs.getString("nombre"), rs.getString("foto"),
							rs.getDate("fecha").toLocalDate(), ar1));


				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return resultado;
	}

	@Override
	public Discos mostrarPorNombre(String nombre) {
		Discos resultado = new DiscosDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement(MOSTRARPORNOMBRE);
				ps.setString(1, nombre);
				rs = ps.executeQuery();
				if (rs.next()) {
					ArtistasDAOImp ar = new ArtistasDAOImp();
					Artistas ar1 = ar.mostrarPorId(rs.getInt("id_artistas"));
					resultado = (new DiscosDAOImp(rs.getInt("id"), rs.getString("nombre"), rs.getString("foto"),
							rs.getDate("fecha").toLocalDate(), ar1));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return resultado;
	}

}
