package bellicose.com.cifrado.dto;

public class PmSucursalDTO {

	private int idSucursal;
	private int idNegocio;
	private String nombreSucursal;
	private String direccionSucursal;
	private String direccionDetalleSucursal;
	private double longitud;
	private double latitud;
	private int idEstado;
	
	public int getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	public int getIdNegocio() {
		return idNegocio;
	}
	public void setIdNegocio(int idNegocio) {
		this.idNegocio = idNegocio;
	}
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getDireccionSucursal() {
		return direccionSucursal;
	}
	public void setDireccionSucursal(String direccionSucursal) {
		this.direccionSucursal = direccionSucursal;
	}
	public String getDireccionDetalleSucursal() {
		return direccionDetalleSucursal;
	}
	public void setDireccionDetalleSucursal(String direccionDetalleSucursal) {
		this.direccionDetalleSucursal = direccionDetalleSucursal;
	}
}
