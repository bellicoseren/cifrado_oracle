package bellicose.com.cifrado.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import bellicose.com.cifrado.dao.PmTiposDAO;
import bellicose.com.cifrado.dto.PmTipoDTO;

public class PmTipoTest {

	
	@Test
	public void leerUsuarioTest() {
		PmTiposDAO dao = new PmTiposDAO();
		List<PmTipoDTO> userDTOs = new ArrayList<>();
		try {
//			assertNotNull(dao.leer());
			userDTOs = dao.leer();
			for (PmTipoDTO userDTO : userDTOs) {
				System.out.println(userDTO.getIdTipo() + " " + userDTO.getNombre() + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void agregarUsuarioTest() {
		PmTipoDTO dto = new PmTipoDTO();
		PmTiposDAO dao = new PmTiposDAO();
		dto.setIdTipo(1);
		dto.setNombre("NombreUsuario2");
		
		try {
			dao.agregar(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void buscarUsuarioTest() {
		PmTipoDTO dto = new PmTipoDTO();
		PmTiposDAO dao = new PmTiposDAO();
		try {
			dto = dao.buscar(1);
			System.out.println(dto.getIdTipo());
			System.out.println(dto.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public void actualizarUsuario() {
		PmTiposDAO dao = new PmTiposDAO();
		PmTipoDTO dto = new PmTipoDTO();
		dto.setIdTipo(2);
		dto.setNombre("NombreUsuario1");
		try {
			dao.actualizar(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void borrarUsuario() {
		PmTiposDAO dao = new PmTiposDAO();
		try {
			dao.borrar(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void insertarCifrado(){
		PmTiposDAO dao = new PmTiposDAO();
		try {
			List<PmTipoDTO> dtos = dao.leer();
			Iterator<PmTipoDTO> it = dtos.iterator();

			
			while(it.hasNext()){
				PmTipoDTO dto = it.next();
				System.out.println(dto.getIdTipo() + " " + dto.getNombre());
			dao.insertarCifrado(dto);
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
