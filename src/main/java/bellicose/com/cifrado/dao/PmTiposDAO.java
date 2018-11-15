package bellicose.com.cifrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bellicose.com.cifrado.conexion.ConnectionFactory;
import bellicose.com.cifrado.dto.PmTipoDTO;
import bellicose.com.cifrado.inteface.IPmTipos;
import bellicose.com.cifrado.util.Cifrado;

public class PmTiposDAO implements IPmTipos {
	Connection conn;
	String clave = "1111111111111111";
	String vi = "1111111111111111";
	
	@Override
	public List<PmTipoDTO> leer() throws Exception {
		String leer = "select ID_TIPO, NOMBRE_TIPO from FRAMEWORK.PM_TIPOS_C";
		conn = ConnectionFactory.getInstance().getConexion();
		if(conn == null) {
			System.out.println("No se estableció la conexion");
		}
		PreparedStatement ps = conn.prepareStatement(leer);
		ResultSet rs = ps.executeQuery();
		List<PmTipoDTO> users = new ArrayList<>();
		PmTipoDTO userDTO = null;
		while(rs.next()) {
			userDTO = new PmTipoDTO();
			userDTO.setIdTipo(rs.getInt("ID_TIPO"));
//			userDTO.setNombre(Cifrado.decifrar(clave, vi, rs.getString("NOMBRE_TIPO")));
			userDTO.setNombre(rs.getString("NOMBRE_TIPO"));
			
			
			users.add(userDTO);
		}
		if(rs != null) {
			rs.close();
		}
		if(ps != null) {
			ps.close();
		}
		if(conn != null) {
			conn.close();
		}
		return users;
	}

	@Override
	public PmTipoDTO buscar(int idUsuario) throws Exception {
		String buscar = "select * from usuario where id=?";
		conn = ConnectionFactory.getInstance().getConexion();
		if(conn == null) {
			System.out.println("No se estableció conexion");
		}
		PreparedStatement ps = conn.prepareStatement(buscar);
		ps.setInt(1, idUsuario);
		PmTipoDTO usuarioDTOs = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			usuarioDTOs = new PmTipoDTO();
			usuarioDTOs.setIdTipo(rs.getInt("id"));
			usuarioDTOs.setNombre(Cifrado.decifrar(clave, vi, rs.getString("nombre")));
		}
		return usuarioDTOs;
	}

	@Override
	public boolean actualizar(PmTipoDTO userDTO) throws Exception {
		String actualizar = "update usuario set nombre=?, apellido=?, fecha_nac=? where id=?";
		conn = ConnectionFactory.getInstance().getConexion();
		if(conn == null) {
			System.out.println("Fallo en la conexión");
		}
		PreparedStatement ps = conn.prepareStatement(actualizar);
		ps.setString(1, Cifrado.cifrar(clave, vi, userDTO.getNombre()));
		ps.setInt(4, userDTO.getIdTipo());
		
		boolean resultado = ps.executeUpdate() > 0;
		if(resultado) {
			System.out.println("Registro actualizado");
		} else {
			System.out.println("No fue posible actualzar");
		}
		
		if(ps != null) {
			ps.close();
		}
		if(conn != null) {
			conn.close();
		}
		
		return resultado;
	}

	@Override
	public boolean borrar(int idUsuario) throws Exception {
		String borrar = "delete from usuario where id=?";
		conn = ConnectionFactory.getInstance().getConexion();
		if(conn == null) {
			System.out.println("No se estableció conexion");
		}
		PreparedStatement ps = conn.prepareStatement(borrar);
		ps.setInt(1, idUsuario);
		
		boolean resultado = ps.executeUpdate() > 0;
		if(resultado) {
			System.out.println("Registro borrado");
		} else {
			System.out.println("No fue posible borrar");
		}
		if(ps != null) {
			ps.close();
		}
		if(conn != null) {
			conn.close();
		}
		return resultado;
	}

	@Override
	public boolean agregar(PmTipoDTO dto) throws Exception {
		String agregar = "insert into usuario (id, nombre, apellido, fecha_nac) values (?,?,?,?)";
		conn = ConnectionFactory.getInstance().getConexion();
		if(conn == null) {
			System.out.println("Fallo en la conexion");
		}
		PreparedStatement ps = conn.prepareStatement(agregar);
		ps.setInt(1, dto.getIdTipo());
		ps.setString(2, Cifrado.cifrar(clave, vi, dto.getNombre()));
		ps.executeUpdate();
		boolean result = ps.getUpdateCount() > 0;
		if(result) {
			System.out.println("Registro agregado");
		} else {
			System.out.println("No se agregó el registro");
		}
		if(ps != null) {
			ps.close();
		}
		if(conn != null) {
			conn.close();
		}
		return result;
	}

	@Override
	public boolean insertarCifrado(PmTipoDTO dto) throws Exception {
//		String insertarCif = "INSERT INTO FRAMEWORK.PM_TIPOS_C(ID_TIPO, NOMBRE_TIPO) SELECT ?, ? FROM FRAMEWORK.PM_TIPOS";
		String insertarCif = "INSERT INTO FRAMEWORK.PM_TIPOS_C values(?,?)";
		conn = ConnectionFactory.getInstance().getConexion();
		if(conn == null)
			System.out.println("Fallo en la conexion");
		PreparedStatement ps = conn.prepareStatement(insertarCif);
		ps.setInt(1, dto.getIdTipo());
		ps.setString(2, Cifrado.cifrar(clave, vi, dto.getNombre()));
		ps.executeUpdate();
		boolean result = ps.getUpdateCount() > 0;
		if(result){
			System.out.println("Registro cifrado agregado");
		} else {
			System.out.println("No fué posible agregar el registro cifrado");
		}
		if(ps != null){
			ps.close();
		}
		if(conn != null){
			conn.close();
		}
		return result;
	}

	
}
