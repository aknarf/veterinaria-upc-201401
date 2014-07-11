package trasveterinaria.modelo;

import java.sql.Date;

public class Citas {
	private int nroCita;
	private String feha;
	private String estado;
    private String cantidad;
    private String notasMedicas;
    private String imagen;
    private String tipo;
    private int idtarea;
    private int idmascota;
    private int dnidoc;
    
	public int getNroCita() {
		return nroCita;
	}
	public void setNroCita(int nroCita) {
		this.nroCita = nroCita;
	}
	public String getFeha() {
		return feha;
	}
	public void setFeha(String feha) {
		this.feha = feha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getNotasMedicas() {
		return notasMedicas;
	}
	public void setNotasMedicas(String notasMedicas) {
		this.notasMedicas = notasMedicas;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdtarea() {
		return idtarea;
	}
	public void setIdtarea(int idtarea) {
		this.idtarea = idtarea;
	}
	public int getIdmascota() {
		return idmascota;
	}
	public void setIdmascota(int idmascota) {
		this.idmascota = idmascota;
	}
	public int getDnidoc() {
		return dnidoc;
	}
	public void setDnidoc(int dnidoc) {
		this.dnidoc = dnidoc;
	}

	

}
