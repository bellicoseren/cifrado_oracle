package bellicose.com.cifrado.inteface;

import java.util.List;

import bellicose.com.cifrado.dto.PmTipoDTO;

public interface IPmTipos {

	List<PmTipoDTO> leer() throws Exception;
	PmTipoDTO buscar(int idTipo) throws Exception;
	boolean actualizar(PmTipoDTO pmTipoDTO) throws Exception;
	boolean borrar(int idTipo) throws Exception;
	boolean agregar(PmTipoDTO dto) throws Exception;
	boolean insertarCifrado(PmTipoDTO dto) throws Exception;
}
