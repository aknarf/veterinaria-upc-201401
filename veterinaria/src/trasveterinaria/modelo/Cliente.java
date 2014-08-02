package trasveterinaria.modelo;

import java.io.File;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String correoelectronico;
	private String direccion;
	private File foto;
	private String celular;
	private String telefonofijo;
	private String ruc;
	private int cantMascota;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApePaterno() {
		return apePaterno;
	}
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	public String getApeMaterno() {
		return apeMaterno;
	}
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	public String getCorreoelectronico() {
		return correoelectronico;
	}
	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public File getFoto() {
		return foto;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefonofijo() {
		return telefonofijo;
	}
	public void setTelefonofijo(String telefonofijo) {
		this.telefonofijo = telefonofijo;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public int getCantMascota() {
		return cantMascota;
	}
	public void setCantMascota(int cantMascota) {
		this.cantMascota = cantMascota;
	}
	
	

}
