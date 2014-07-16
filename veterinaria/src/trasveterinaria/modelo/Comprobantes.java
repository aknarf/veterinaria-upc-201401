package trasveterinaria.modelo;

public class Comprobantes {
	private int nroComprobante;
	private String correlativo;
	private String tipo;
	private String direccion;
	private String fechaRegistro;
	private int nroCita;
	public int getNroComprobante() {
		return nroComprobante;
	}
	public void setNroComprobante(int nroComprobante) {
		this.nroComprobante = nroComprobante;
	}
	public String getCorrelativo() {
		return correlativo;
	}
	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getNroCita() {
		return nroCita;
	}
	public void setNroCita(int nroCita) {
		this.nroCita = nroCita;
	}
	
	
	

}
