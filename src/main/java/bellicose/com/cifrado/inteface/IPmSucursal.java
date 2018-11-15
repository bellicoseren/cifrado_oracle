package bellicose.com.cifrado.inteface;

import java.util.List;

import bellicose.com.cifrado.dto.*;

public interface IPmSucursal {

	List<PmSucursalDTO> leer() throws Exception;
	PmSucursalDTO buscar(int idSucursal) throws Exception;
	boolean actualizar(PmSucursalDTO dto) throws Exception;
	boolean agregar(PmSucursalDTO dto) throws Exception;
	boolean borrar(int idSucursal) throws Exception;
	boolean insertarCifrado(PmSucursalDTO dto) throws Exception;
}
