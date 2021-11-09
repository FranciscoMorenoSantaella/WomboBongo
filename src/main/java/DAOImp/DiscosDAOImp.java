package DAOImp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
	private List<Artistas> arl;

	public DiscosDAOImp() {
		super();
	}

	public DiscosDAOImp(String nombre, String foto, LocalDateTime fecha, Artistas ar) {
		super(nombre, foto, fecha, ar);

	}

	public DiscosDAOImp(int id, String nombre, String foto, LocalDateTime fecha, Artistas ar) {
		super(id, nombre, foto, fecha, ar);
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
				Timestamp a = Timestamp.valueOf(this.fecha);
				ps.setTimestamp(3, a);
				System.out.println(this.ar);
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
				Timestamp a = Timestamp.valueOf(this.fecha); // Para convertir TimeStap a Date
				ps.setTimestamp(3, a);
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
		
	}

	@Override
	public List<Discos> mostrarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discos mostrarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discos mostrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
