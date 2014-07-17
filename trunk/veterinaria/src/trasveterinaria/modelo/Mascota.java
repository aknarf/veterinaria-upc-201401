package trasveterinaria.modelo;

import java.util.Date;

public class Mascota {

	private int IdMascota;
	private String Nombre;
	private String Genero;
	private String TipoSangre;
	private String Esterilizado;
	private String Tamaño;
	private String Actividad;
	private int Peso;
	private Date FechaNacimiento;
	private String Alergia;
	private int Cliente_Dni;
	private int Raza_idRaza;
	//private int Cant_Atenciones;


	public int getIdMascota() {
		return IdMascota;
	}
	
	public void setIdMascota(int IdMascota) {
		this.IdMascota = IdMascota;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public String getGenero() {
		return Genero;
	}
	
	public void setGenero(String Genero) {
		this.Genero = Genero;
	}
	
	public String getTipoSangre() {
		return TipoSangre;
	}
	
	public void setTipoSangre(String TipoSangre) {
		this.TipoSangre = TipoSangre;
	}
	
	public String getEsterilizado() {
		return Esterilizado;
	}
	
	public void setEsterilizado(String Esterilizado) {
		this.Esterilizado = Esterilizado;
	}
	
	public String getTamaño() {
		return Tamaño;
	}
	
	public void setTamaño(String Tamaño) {
		this.Tamaño = Tamaño;
	}
	
	public String getActividad() {
		return Actividad;
	}
	
	public void setActividad(String Actividad) {
		this.Actividad = Actividad;
	}
	
	public int getPeso() {
		return Peso;
	}
	
	public void setPeso(int Peso) {
		this.Peso = Peso;
	}
	
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	
	public void setFechaNacimiento(Date FechaNacimiento) {
		this.FechaNacimiento = FechaNacimiento;
	}
	
	public String getAlergia() {
		return Alergia;
	}
	
	public void setAlergia(String Alergia) {
		this.Alergia = Alergia;
	}

	public int getCliente_Dni() {
		return Cliente_Dni;
	}
	
	public void setCliente_Dni(int Cliente_Dni) {
		this.Cliente_Dni = Cliente_Dni;
	}
	
	public int getRaza_idRaza() {
		return Raza_idRaza;
	}
	
	public void setRaza_idRaza(int Raza_idRaza) {
		this.Raza_idRaza = Raza_idRaza;
	}

	/*
	public int getCant_Atenciones() {
		return Cant_Atenciones;
	}

	public void setCant_Atenciones(int cant_Atenciones) {
		Cant_Atenciones = cant_Atenciones;
	}
	*/
	
}
