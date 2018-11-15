package bellicose.com.cifrado.dao;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import bellicose.com.cifrado.dto.PmSucursalDTO;

public class PmSucursalTest {

	public void leer(){
		PmSucursalDAO dao = new PmSucursalDAO();
		try {
			List<PmSucursalDTO> sucursales = dao.leer();
			for (PmSucursalDTO pmSucursalDTO : sucursales) {
				System.out.println(
						pmSucursalDTO.getIdSucursal() + " " +
						pmSucursalDTO.getIdNegocio() + " " +
						pmSucursalDTO.getNombreSucursal() + " " +
						pmSucursalDTO.getDireccionSucursal() + " " +
						pmSucursalDTO.getDireccionDetalleSucursal() + " " +
						pmSucursalDTO.getLongitud() + " " +
						pmSucursalDTO.getLatitud() + " " +
						pmSucursalDTO.getIdEstado());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void insertarCifTest(){
		PmSucursalDAO dao = new PmSucursalDAO();
		try {
			List<PmSucursalDTO> dtos = dao.leer();
			Iterator<PmSucursalDTO> it = dtos.iterator();
			
			while(it.hasNext()){
				PmSucursalDTO dto = it.next();
				dao.insertarCifrado(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
