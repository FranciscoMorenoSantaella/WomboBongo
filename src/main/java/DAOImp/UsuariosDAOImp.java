package DAOImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.UsuariosDAO;
import Utils.Conexion;
import model.Artistas;
import model.ListaRP;
import model.Usuarios;

public class UsuariosDAOImp extends Usuarios implements UsuariosDAO {
	private static final String MOSTRARTODOS = "SELECT id,nombre,contraseña,correo,foto FROM usuarios";
	private static final String AÑADIRUSUARIOS = "INSERT INTO usuarios (nombre,contraseña,correo,foto) VALUES (?,?,?,?)";
	private static final String BORRARUSUARIOS = "DELETE FROM usuarios WHERE usuarios.id =?";
	private static final String EDITARUSUARIOS = "UPDATE usuarios set nombre=?, contraseña=?, correo=?,foto=? WHERE id=?";
	private static final String MOSTRARPORID = "SELECT id,nombre,contraseña,correo,foto FROM usuarios WHERE id=?";
	private static final String MOSTRARPORNOMBRE = "SELECT id,nombre,contraseña,correo,foto FROM usuarios WHERE nombre=?";
	private static final String MOSTRARMISLISTAS = "SELECT listarp.nombre FROM listarp,usuarios_listarp, usuarios WHERE usuarios.id = usuarios_listarp.id_usuario";
	private static final String AÑADIRLISTASALUSUARIO = "INSERT INTO usuarios_listarp (id_usuario,id_listarp) VALUES (?,?)";
	private static final String BORRARLISTASALUSUARIO = "DELETE FROM usuarios_listarp WHERE id=?";

	private List<ListaRP> lrp;
	private Connection con;
	private boolean persisted = false;

	public UsuariosDAOImp() {
		super();
	}

	public UsuariosDAOImp(String nombre, String contraseña, String correo, String foto) {
		super(nombre, contraseña, correo, foto);
	}

	public UsuariosDAOImp(int id, String nombre, String contraseña, String correo, String foto) {
		super(id, nombre, contraseña, correo, foto);
	}

	public UsuariosDAOImp(String nombre, String contraseña, String correo, String foto, List<ListaRP> lrp) {
		super(nombre, contraseña, correo, foto, lrp);
	}

	public UsuariosDAOImp(int id, String nombre, String contraseña, String correo, String foto, List<ListaRP> lrp) {
		super(id, nombre, contraseña, correo, foto, lrp);
	}

	@Override
	public void guardar() {
		con = Conexion.getConnection();
		if (con != null) {

			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(AÑADIRUSUARIOS, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, this.nombre);
				ps.setString(2, this.contraseña);
				ps.setString(3, this.correo);
				ps.setString(4, this.foto);
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
				ps = con.prepareStatement(EDITARUSUARIOS);
				ps.setString(1, this.nombre);
				ps.setString(2, this.contraseña);
				ps.setString(3, this.correo);
				ps.setString(4, this.foto);
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
				ps = con.prepareStatement(BORRARUSUARIOS);
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
	public List<Usuarios> mostrarTodos() {
		List<Usuarios> resultado = new ArrayList<Usuarios>();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARTODOS);
				rs = ps.executeQuery();
				while (rs.next()) {
					resultado.add(new Usuarios(rs.getInt("id"), rs.getString("nombre"), rs.getString("contraseña"),
							rs.getString("correo"), rs.getString("foto")));
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

	public Usuarios mostrarPorId(int id) {
		Usuarios ar = new UsuariosDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORID);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if (rs.next()) {
					ar = new UsuariosDAOImp(rs.getInt("id"), rs.getString("nombre"), rs.getString("contraseña"),
							rs.getString("correo"), rs.getString("foto"));

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ar;
	}

	@Override
	public Usuarios mostrarPorNombre(String nombre) {
		Usuarios us = new UsuariosDAOImp();
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(MOSTRARPORNOMBRE);
				ps.setString(1, nombre);
				rs = ps.executeQuery();
				if (rs.next()) {
					us = new UsuariosDAOImp(rs.getInt("id"), rs.getString("nombre"), rs.getString("contraseña"),
							rs.getString("correo"), rs.getString("foto"));

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return us;
	}

	@Override
	public void añadirlistadelusuario(Usuarios us, ListaRP lrp) {
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(AÑADIRLISTASALUSUARIO);
				ps.setInt(1, us.getId());
				ps.setInt(2, lrp.getId());
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public void borrarlistadelusuario(ListaRP lrp) {
		con = Conexion.getConnection();
		if (con != null) {
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = con.prepareStatement(BORRARLISTASALUSUARIO);
				ps.setInt(1,lrp.getId());
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

}
