package bellicose.com.cifrado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bellicose.com.cifrado.conexion.ConnectionFactory;
import bellicose.com.cifrado.dto.PmSucursalDTO;
import bellicose.com.cifrado.inteface.IPmSucursal;
import bellicose.com.cifrado.util.Cifrado;

public class PmSucursalDAO implements IPmSucursal{
	Connection conn;
	String clave = "1111111111111111";
	String vi = "1111111111111111";
	
	@Override
	public List<PmSucursalDTO> leer() throws Exception {
		String leer = "SELECT ID_SUCURSAL, ID_NEGOCIO, NOMBRE_SUCURSAL, DIRECCION_SUCURSAL,"
				+ " DIRECCION_DETALLE_SUCURSAL, LONGITUD, LATITUD, ID_ESTADO FROM FRAMEWORK.PM_SUCURSALES_C";
		conn = ConnectionFactory.getInstance().getConexion();
		if(conn == null){
			System.out.println("No se estableció conexión con la base de datos");
		}
		List<PmSucursalDTO> dtos = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement(leer);
		ResultSet rs = ps.executeQuery();
		PmSucursalDTO dto;
		while(rs.next()){
			dto = new PmSucursalDTO();
			dto.setIdSucursal(rs.getInt("ID_SUCURSAL"));
			dto.setIdNegocio(rs.getInt("ID_NEGOCIO"));
			dto.setNombreSucursal(Cifrado.decifrar(clave, vi, rs.getString("NOMBRE_SUCURSAL")));
//			dto.setNombreSucursal(rs.getString("NOMBRE_SUCURSAL"));
			dto.setDireccionSucursal(Cifrado.decifrar(clave, vi, rs.getString("DIRECCION_SUCURSAL")));
//			dto.setDireccionSucursal(rs.getString("DIRECCION_SUCURSAL"));
			dto.setDireccionDetalleSucursal(rs.getString("DIRECCION_DETALLE_SUCURSAL") != null?Cifrado.decifrar(clave, vi, rs.getString("DIRECCION_DETALLE_SUCURSAL")):rs.getString("DIRECCION_DETALLE_SUCURSAL"));
//			dto.setDireccionDetalleSucursal(rs.getString("DIRECCION_DETALLE_SUCURSAL"));
			dto.setLongitud(rs.getDouble("LONGITUD"));
			dto.setLatitud(rs.getDouble("LATITUD"));
			dto.setIdEstado(rs.getInt("ID_ESTADO"));
			dtos.add(dto);
		}
		if(conn != null){
			conn.close();
		}
		if(rs != null){
			rs.close();
		}
		if(ps != null){
			ps.close();
		}
		
		return dtos;
	}

	@Override
	public PmSucursalDTO buscar(int idSucursal) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizar(PmSucursalDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregar(PmSucursalDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(int idSucursal) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertarCifrado(PmSucursalDTO dto) throws Exception {
		String insertarCif = "INSERT INTO FRAMEWORK.PM_SUCURSALES_C (ID_SUCURSAL, ID_NEGOCIO, NOMBRE_SUCURSAL, DIRECCION_SUCURSAL,"
				+ " DIRECCION_DETALLE_SUCURSAL, LONGITUD, LATITUD, ID_ESTADO) values (?,?,?,?,?,?,?,?)";
		conn = ConnectionFactory.getInstance().getConexion();
		if(conn == null){
			System.out.println("No se estableció conexion");
		}
		PreparedStatement ps = conn.prepareStatement(insertarCif);
		ps.setInt(1, dto.getIdSucursal());
		ps.setInt(2, dto.getIdNegocio());
		ps.setString(3, Cifrado.cifrar(clave, vi, dto.getNombreSucursal()));
		ps.setString(4, Cifrado.cifrar(clave, vi, dto.getDireccionSucursal()));
		ps.setString(5, dto.getDireccionDetalleSucursal());
		ps.setDouble(6, dto.getLongitud());
		ps.setDouble(7, dto.getLatitud());
		ps.setInt(8, dto.getIdEstado());
		
		boolean result = ps.executeUpdate() > 0;
		if(result){
			System.out.println("Cifrado insertado correctamente");
		} else {
			System.out.println("Falló la inserción");
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
